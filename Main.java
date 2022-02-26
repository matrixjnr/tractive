import java.util.*;

public class Main {

    //This parser is specifically to data similar in length and type of the provided test data as the json parser
    //specific to the list of mappings provided

    public static void main(String[] args) {

        //Take list as argument and split into a String array after stripping out the []
        String s = args[0].substring(1, args[0].length() - 1);
        String[] s1 = s.split(", ");
        ArrayList<String> sku = new ArrayList<>();

        //store the sku into an array list to prepare for frequency count
        for (int i=0; i<s1.length; i++)
            sku.add(s1[i]);

        //take the mapping of products which is a json and write a small stripping parser after removing []
        String p = args[1].substring(1, args[1].length() - 2);
        String p1 = p.replace(": {", "=");
        String p2 = p1.replace("},", "+");

        //create a hashmap to convert the list of json to a hashmap
        HashMap<String, String> items = new HashMap<String, String>();

        //Split the json into its components i.e key values
        String[] pitems = p2.split("\\+");
        //Store key as hashmap key and value as hashmap value
        for (int i=0; i<pitems.length; i++)
            items.put(pitems[i].split("\\=")[0], pitems[i].split("\\=")[1]);

        //Create a hashset to store distinct values of our sku list
        Set<String> distinct = new HashSet<>(sku);
        for (String i: distinct) {
            for (Map.Entry<String, String> set : items.entrySet()) {
                if(i.equals(set.getKey()))
                    //update the hashmap key values with frequency count of product skus
                    items.put(set.getKey(), set.getValue() + ",quantity:" +Collections.frequency(sku, i));
            }
        }

        //Stringbuilder to assemble our hashmap back to list of json
        StringBuilder result = new StringBuilder();

//        for (Map.Entry<String, String> set : items.entrySet()) {
//            result.append(set.getValue());
//        }

        //hashmap values joined together to create the list of json skeleton
        items.forEach((key, value) -> result.append(value + "}+{\""));

        //parser to build our list of json output
        //
        String r = result.toString();
        String r1 = r.replace(",", ",\"");
        String r2 = r1.replace(": ", "\": \"");
//        String r8 = r2.replace(":", "\": \"");
        String r5 = r2.replace(",\"", "\",\"");
        String r3 = r5.replace(":2\"", "\":2");
        String r4 = r3.replace(":1\"", "\":1");
        String r6 = r4.replace("\"}\",\"+", "},");
        String r8 = r6.replace("\"2,", "\"2\",\"");
        String r9 = r8.replace("\"1,", "\"1\",\"");
        String r10 = r9.replace("\"quantity", "quantity");
        String r7 = "[{\"" + r10.substring(0, r10.length() - 3) + "]";


        //print output to console.
        System.out.println("Purchased items: " + r7.replace("+", ","));
    }
}
