package workTest;

import bambooSwords.BfsDfsTree.TreeNode;
import bambooSwords.generalClass.ListNode;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.*;

import static java.util.Objects.nonNull;
import static org.junit.Assert.assertTrue;

public class GeneralTest {

    @Test
    public void method(){
        List<Integer> list = new ArrayList<>();
        list.forEach(l -> {
            if (l == 1){
                System.out.print("true");
            }
        });
    }

    @Test
    public void testStream(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        boolean match = list.stream().anyMatch(i -> i.equals(5));
        boolean first = list.stream().filter(f -> f.equals(5)).findFirst().isPresent();
        System.out.println(match + " " + first);
    }

    @Test
    public void testMap(){
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        map.remove(0, -1);
        System.out.print(map.size());

        HashMap<String, String> map2 = new HashMap<>();
        String a = map2.get("q");
        System.out.print(a);

    }

    @Test
    public void testArray(){
        int[] n = {1,2,3};
        List list = Arrays.asList(n);
    }

    @Test
    public void testNode(){
        ListNode n1 = new ListNode(1);
        n1.setNext(null);

        ListNode n2 = new ListNode(2);
        n2.setNext(n1.getNext());
    }

    @Test
    public void testSplit(){
        String s = "1::k::3";
//        List<String> ss = splitStringByDoubleColon(s);
//        List<Integer> si = splitStringByDoubleColon(s);
//        for (int i : si){
//            System.out.print(i);
//        }

        List<Integer> l = new ArrayList<>();
        l.add(1);
        Integer[] test = new Integer[1];
        for (int i = 0; i < l.size(); i++){
            test[i] = l.get(i);
        }
    }

    private List splitStringByDoubleColon(String s){
        return Arrays.asList(s.split("::"));
    }

    @Test
    public void testOptinal(){
        TreeNode t = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        System.out.print(Optional.of(t.left));

    }

    @Test
        public void testExcel() throws Exception {
            InputStream inputStream =new FileInputStream("src/test/resource/report.xlsx");
            XSSFWorkbook inputWorkbook = new XSSFWorkbook(inputStream);
            inputWorkbook.setMissingCellPolicy(Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
            XSSFSheet sheet = inputWorkbook.getSheetAt(0);
            int numberOfRows = sheet.getPhysicalNumberOfRows();

            XSSFRow headers = sheet.getRow(0);
            int indexViewabilityThreshold = getHeaderIndex(headers, "Viewability %");
            int indexViewabilityVendorName = getHeaderIndex(headers, "Viewability Vendor");
            int indexViewabilityTargetId = getHeaderIndex(headers, "Viewability Target Id");

            System.out.print("Total number of columns: {}, viewability: [{}], viewabilityIndex: {}" + indexViewabilityThreshold);

            for (int i = 1; i < numberOfRows; i++) {
                XSSFRow row = sheet.getRow(i);
                if (getViewabilityThreshold(row, indexViewabilityThreshold) > 0.0) {
                    String vendorName = row.getCell(indexViewabilityVendorName).toString();
                } else if (StringUtils.isNotBlank(row.getCell(indexViewabilityTargetId).toString())) {
                    String vendorName = row.getCell(indexViewabilityVendorName).toString();
                } else {
                    Object vendorName = row.getCell(indexViewabilityVendorName);
                    assertTrue(Objects.isNull(vendorName) || StringUtils.isBlank(vendorName.toString()));
                }
            }
            inputWorkbook.close();
        }

    private int getHeaderIndex(XSSFRow headers, String headerName) {
        for (int i = 0; i < headers.getPhysicalNumberOfCells(); i++) {
            if (headerName.equals(headers.getCell(i).toString())) {
                return i;
            }
        }
        return -1;
    }

    private Double getViewabilityThreshold(XSSFRow row, int index) {
        Object threshold = row.getCell(index);
        if (nonNull(threshold) && StringUtils.isNotBlank(threshold.toString())) {
            return Double.valueOf(threshold.toString());
        }
        return 0.0;
    }

}
