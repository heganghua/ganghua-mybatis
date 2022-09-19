package xyz.ganghua.shange.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.util.StringUtils;

import xyz.ganghua.shange.dao.before.BeforeCode;

public class WriteWordService {

    public static final String REGEX_SPLIT = "\\\\";

    public static final String LAST_NAME = "不动产调查登记申请表.doc";

    public static final String CODE_NAME = "宗地代码：";

    /**
     * 预编宗地代码与文件地址映射关系
     */
    public static Map<String, String> PATH_MAPPING = new HashMap<String, String>();

    /**
     * excel数据临时存储
     */
    public static List<BeforeCode> CACHED_DATA_LIST = new ArrayList<>();

    /**
     * 预编宗地代码映射文件地址
     * 
     * @param path
     */
    public static void doPathMappingForLocalPath(List<String> param) {
        if (null == param || param.size() == 0) {
            throw new RuntimeException("列表为空");
        }

        for (String item : param) {
            String[] split = item.split(REGEX_SPLIT);
            if (null == split) {
                continue;
            }
            String fileName = split[split.length - 1];
            String beforeCode = fileName.replace(LAST_NAME, "");
            PATH_MAPPING.put(beforeCode, item);
        }
    }

    /**
     * 获取文件路径
     * 
     * @param path
     * @return
     */
    public static List<String> getFilePath(String path) {
        File file = new File(path);
        if (!file.exists() && !file.isDirectory()) {
            throw new RuntimeException("文件路径错误");
        }
        LinkedList<File> directoryList = new LinkedList<>();
        List<String> filePathList = new ArrayList<>();
        directoryList.add(file);

        while (!directoryList.isEmpty()) {
            File f = directoryList.poll();
            File[] listFiles = f.listFiles();
            if (null != listFiles) {
                for (File item : listFiles) {
                    if (item.isDirectory()) {
                        directoryList.add(item);
                    } else {
                        filePathList.add(item.getAbsolutePath());
                    }
                }
            }
        }
        return filePathList;
    }

    /**
     * 根据预编宗地代码获取对应的word文件路径，<br>
     * 并写入对应的宗地代码、不动单元号
     * 
     * @param fileName
     */
    public static void simpleRead(String fileName) {

        EasyExcel.read(fileName, BeforeCode.class, new AnalysisEventListener<BeforeCode>() {

            @Override
            public void invoke(BeforeCode data, AnalysisContext context) {

                // 过滤宗地代码或者不动产单元号为空的数据
                if (null != data.getCode() && null != data.getRealEstateUnitNumber()) {
                    CACHED_DATA_LIST.add(data);
                }
            }

            @Override
            public void doAfterAllAnalysed(AnalysisContext context) {
                // 读完之后做的事情
            }

        }).sheet().doRead();
    }

    /**
     * 打开word，填充信息
     * 
     * @param filePath
     * @param beforeCode
     * @throws FileNotFoundException
     */
    public static void openWordPaddingInfo(String filePath, BeforeCode info) {
        if (null == filePath || null == info) {
            throw new RuntimeException("填充信息失败， 路径或者内容为空");
        }
        System.out.println(filePath + ": " + info);
        FileInputStream fileInputStream = null;
        XWPFDocument doc = null;
        try {
            fileInputStream = new FileInputStream(filePath);
            doc = new XWPFDocument(fileInputStream);

            // 13行，代表宗地代码
            List<XWPFParagraph> paragraphs = doc.getParagraphs();
            XWPFParagraph xwpfParagraph = paragraphs.get(13);
            String text = xwpfParagraph.getText();
            if (StringUtils.isEmpty(text)) {
                XWPFRun createRun = xwpfParagraph.createRun();
                createRun.setText(CODE_NAME + info.getCode());
                createRun.setFontSize(16);
            } else {
                XWPFRun createRun = xwpfParagraph.createRun();
                createRun.setText(info.getCode());
                createRun.setFontSize(16);
            }

            // 表格暂时不做处理
            /*Iterator<XWPFTable> tablesIterator = doc.getTablesIterator();
            // 第一个表格
            XWPFTable table = tablesIterator.next();
            List<XWPFTableRow> rows = table.getRows();
            // 第二行第三个单元格 为宗地代码
            XWPFTableRow xwpfTableRow = rows.get(1);
            // xwpfTableRow.removeCell(3);
            // xwpfTableRow.addNewTableCell();
            XWPFTableCell cell = xwpfTableRow.getCell(3);
            cell.removeParagraph(0);
            cell.setText(info.getCode());
            
            // 不动产单元号
            XWPFTableRow row2 = rows.get(2);
            XWPFTableCell cell2 = row2.getCell(1);
            cell2.removeParagraph(0);
            cell2.setText(info.getRealEstateUnitNumber());*/

            System.out.println("----保存！");
            doc.write(new FileOutputStream(filePath));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                doc.close();
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {

        System.out.println("begin----");
        // 1、读Excel文件，生成数据临时cachedDataList
        simpleRead("code.xlsx");
        // 2、遍历文件夹内容，生成映射pathMapping
        String filePaht = args[0];
        List<String> filePathList = getFilePath(filePaht);
        doPathMappingForLocalPath(filePathList);

        // 3、 根据excel对应编码找到 path
        for (BeforeCode beforeCode : CACHED_DATA_LIST) {
            String bc = beforeCode.getBeforeCode();
            if (!PATH_MAPPING.containsKey(bc)) {
                continue;
            }
            // System.out.println(beforeCode);
            String filePath = PATH_MAPPING.get(bc);
            // 4、 打开word，填充信息
            openWordPaddingInfo(filePath, beforeCode);
            break;
        }

    }

}
