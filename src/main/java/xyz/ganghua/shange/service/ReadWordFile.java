package xyz.ganghua.shange.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableCell;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;

import xyz.ganghua.shange.dao.realestate.RealEstate;

public class ReadWordFile {

    public static void run(File file) {

        // 初始化excel
        ExcelWriterBuilder write = EasyExcel.write("result.xlsx", RealEstate.class);
        ExcelWriterSheetBuilder sheet = write.sheet(0);
        List<RealEstate> resList = new ArrayList<>();

        File[] listFiles = file.listFiles();
        for (int i = 0; i < listFiles.length; i++) {
            File filepath = listFiles[i];
            // System.out.println(filepath.toString());
            RealEstate readWord = readWord(filepath.toString());
            resList.add(readWord);
        }
        sheet.doWrite(resList);
    }

    /**
     * Read word文件内容
     * 
     * @param path
     * @return buffer
     */
    public static RealEstate readWord(String filePath) {
        RealEstate realEstate = new RealEstate();
        try {
            FileInputStream in = new FileInputStream(filePath);// 载入文档 //如果是office2007 docx格式
            if (filePath.toLowerCase().endsWith("doc") || filePath.toLowerCase().endsWith("docx")) {
                // word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
                // 得到word文档的信息
                XWPFDocument xwpf = new XWPFDocument(in);
                // 得到段落信息
                // List<XWPFParagraph> listParagraphs = xwpf.getParagraphs();
                // 得到word中的表格
                Iterator<XWPFTable> it = xwpf.getTablesIterator();
                // 表格1
                XWPFTable table = it.next();
                List<XWPFTableRow> rows = table.getRows();
                // 读取每一行数据
                for (int i = 0; i < rows.size(); i++) {
                    XWPFTableRow row = rows.get(i);
                    // 读取每一列数据
                    List<XWPFTableCell> cells = row.getTableCells();
                    switch (i) {
                        case 1:
                            realEstate.setCode(cells.get(1).getText());
                            break;
                        case 3:
                            realEstate.setName(cells.get(1).getText());
                            break;
                        case 5:
                            realEstate.setIdNumber(cells.get(3).getText());
                            break;
                        case 6:
                            realEstate.setTel(cells.get(3).getText());
                            break;
                        case 11:
                            realEstate.setAddress(cells.get(1).getText());
                            break;
                        case 14:
                            realEstate.setOwnershipIdNumber(cells.get(1).getText());
                            realEstate.setOwnershipIssueDate(cells.get(3).getText());
                            break;
                        case 16:
                            realEstate.setCommonRightHolder(cells.get(1).getText());
                            break;
                        case 19:
                            realEstate.setApprovedArea(cells.get(1).getText());
                            realEstate.setLandArea(cells.get(3).getText());
                            realEstate.setCompletionDate(cells.get(5).getText());
                            break;
                        case 23:
                            realEstate.setBuildingNumber(cells.get(1).getText());
                            realEstate.setLeveTotal(cells.get(2).getText());
                            realEstate.setBuildingStructure(cells.get(4).getText());
                            realEstate.setFloorSpace(cells.get(5).getText());
                            realEstate.setCoveredArea(cells.get(6).getText());
                            realEstate.setOwnershipSource(cells.get(9).getText());
                            realEstate.setEastWall(cells.get(10).getText());
                            realEstate.setSouthWall(cells.get(11).getText());
                            realEstate.setWesterWall(cells.get(12).getText());
                            realEstate.setNorthWall(cells.get(13).getText());
                            break;
                        case 25:
                            realEstate.setTotalArea(cells.get(1).getText());
                            realEstate.setTotalConstructionArea(cells.get(2).getText());
                            break;
                    }
                }

                // 表格2
                XWPFTable table2 = it.next();
                List<XWPFTableRow> rows2 = table2.getRows();
                for (int x = 0; x < rows2.size(); x++) {
                    XWPFTableRow row2 = rows2.get(x);
                    // 读取每一列数据
                    List<XWPFTableCell> cells2 = row2.getTableCells();
                    switch (x) {
                        case 1:
                            realEstate.setArticle(cells2.get(1).getText());
                            break;
                    }
                }
                System.out.println(realEstate);
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("读取表格内容失败！");
        }
        return realEstate;
    }

    public static void initExcel() {
        // excelWriterBuilder = EasyExcel.write("result.xlsx", RealEstate.class)excelWriterBuilder.sheet("山哥");
        // realEstate.setCode("预编号");
        // realEstate.setName("权利人");
        // realEstate.setIdNumber("证件号");
        // realEstate.setTel("联系电话");
        // realEstate.setAddress("坐落");
        // realEstate.setOwnershipIdNumber("权属证件号");
        // realEstate.setOwnershipIssueDate("权属证件发证时间");
        // realEstate.setCommonRightHolder("共有/共用权力人情况");
        // realEstate.setApprovedArea("批准面积");
        // realEstate.setLandArea("宗地面积");
        // realEstate.setCompletionDate("房屋竣工时间");
        // realEstate.setBuildingNumber("幢号");
        // realEstate.setLeveTotal("总层数");
        // realEstate.setBuildingStructure("房屋结构");
        // realEstate.setFloorSpace("占地面积");
        // realEstate.setCoveredArea("建筑面积");
        // realEstate.setOwnershipSource("权属来源");
        // realEstate.setEastWall("墙体归属东");
        // realEstate.setSouthWall("墙体归属南");
        // realEstate.setWesterWall("西墙");
        // realEstate.setNorthWall("北墙");
        // realEstate.setTotalArea("合计占地面积");
        // realEstate.setTotalConstructionArea("合计建筑面积");
        // realEstate.setArticle("权属调查及不动产测量记事");
        // realEstate.setInvestigator("调查员");
        // realEstate.setSurveyDate("调查日期");
        // realEstate.setMeasurer("测量员");
        // realEstate.setMeasurerDate("测量日期");
    }

    public static String readWordBackup(String filePath) {
        try {
            FileInputStream in = new FileInputStream(filePath);// 载入文档 //如果是office2007 docx格式
            if (filePath.toLowerCase().endsWith("doc")) {
                // word 2007 图片不会被读取， 表格中的数据会被放在字符串的最后
                XWPFDocument xwpf = new XWPFDocument(in);// 得到word文档的信息
                // List<XWPFParagraph> listParagraphs = xwpf.getParagraphs();//得到段落信息
                Iterator<XWPFTable> it = xwpf.getTablesIterator();// 得到word中的表格

                // 预编号、 权力人、身份证，联系电话
                String code, name, idNumber, tel;
                // 坐落, 权属证件号, 权属证件号发证时间
                String address, ownershipIdNumber, ownershipIssueDate;
                // 共有/共用权利人情况, 批准面积
                String commonRightHolder, approvedArea;
                // 宗地面积, 房屋竣工时间, 幢号
                String landArea, completionDate, buildingNumber;
                // 总层数, 房屋结构, 占地面积
                String leveTotal, buildingStructure, floorSpace;
                // 建筑面积、 权属来源、墙体归属东、墙体归属南、西墙、北墙
                String coveredArea, ownershipSource, eastWall, southWall, westerWall, northWall;
                // 合计占地面积，合计建筑面积
                String totalArea, totalConstructionArea;
                // 权属调查及不动产测量记事, 调查员, 调查日期, 测量员, 测量日期
                String article, investigator, surveyDate, measurer, measurerDate;

                while (it.hasNext()) {
                    XWPFTable table = it.next();
                    List<XWPFTableRow> rows = table.getRows();
                    // 读取每一行数据
                    for (int i = 0; i < rows.size(); i++) {
                        XWPFTableRow row = rows.get(i);
                        // 读取每一列数据
                        List<XWPFTableCell> cells = row.getTableCells();

                        switch (i) {
                            case 1:
                                code = cells.get(1).getText();
                                break;
                            case 3:
                                name = cells.get(1).getText();
                                break;
                            case 5:
                                idNumber = cells.get(3).getText();
                                break;
                            case 6:
                                tel = cells.get(3).getText();
                                break;
                            case 11:
                                address = cells.get(1).getText();
                                break;
                            case 14:
                                ownershipIdNumber = cells.get(1).getText();
                                ownershipIssueDate = cells.get(3).getText();
                                break;
                            case 16:
                                commonRightHolder = cells.get(1).getText();
                                break;
                            case 19:
                                approvedArea = cells.get(1).getText();
                                landArea = cells.get(3).getText();
                                completionDate = cells.get(5).getText();
                                break;
                            case 23:
                                buildingNumber = cells.get(1).getText();
                                leveTotal = cells.get(2).getText();
                                buildingStructure = cells.get(4).getText();
                                floorSpace = cells.get(5).getText();
                                coveredArea = cells.get(6).getText();
                                ownershipSource = cells.get(9).getText();
                                eastWall = cells.get(10).getText();
                                southWall = cells.get(11).getText();
                                westerWall = cells.get(12).getText();
                                northWall = cells.get(13).getText();
                                break;
                            case 25:
                                totalArea = cells.get(1).getText();
                                totalConstructionArea = cells.get(2).getText();
                                break;
                        }

                        for (int j = 0; j < cells.size(); j++) {
                            XWPFTableCell cell = cells.get(j);
                            // 输出当前的单元格的数据
                            System.out.println(j + " 列 : " + cell.getText());
                        }
                        System.out.println(i + " 行，结束===========================");
                    }

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return filePath;
    }

}
