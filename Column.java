import java.util.ArrayList;
public class Column implements Comparable<Column> {

    private String firstCharInColumn;
    private ArrayList<String> restOfCharacters;

    public Column (String firstChar, ArrayList<String> restOfChars) {
        this.firstCharInColumn = firstChar;
        this.restOfCharacters = restOfChars;
    }

    public String getFirstChar() {
        return this.firstCharInColumn;
    }

    @Override
    public int compareTo(Column column) {
        return this.getFirstChar().compareTo(column.getFirstChar());

    }

    public boolean isLessThan(Column column) {
        boolean isLess = false;
        if (this.getFirstChar().compareTo(column.getFirstChar()) < 0) {
            isLess = true;
        }
        return isLess;

    }

    public ArrayList<String> getRestOfColumn() {
        return null;

    }
    public static void main(String[] args) {


        ToArray aFriggenMessage = new ToArray("Abductions", "CASH MONEY RECORDS TAKING OVER FOR THE NINE NINE AND THE TWO THOUSANDS!");

        String[][] array = aFriggenMessage.bigArray();

        Column[] columns = new Column[7];


            ArrayList<String> chars = new ArrayList<String>();
            chars.add(array[1][0]);
            chars.add(array[2][0]);
            chars.add(array[3][0]);
            chars.add(array[4][0]);
            chars.add(array[5][0]);
            chars.add(array[6][0]);


        columns[0] = new Column((array[0][0]), chars);

        ArrayList<String> chars2 = new ArrayList<String>();

        chars2.add(array[1][1]);
        chars2.add(array[2][2]);
        chars2.add(array[3][3]);
        chars2.add(array[4][4]);
        chars2.add(array[5][5]);
        chars2.add(array[6][6]);

        columns[1] = new Column((array[0][1]), chars2);

        System.out.println(columns[0].compareTo(columns[1]));

    }

}
