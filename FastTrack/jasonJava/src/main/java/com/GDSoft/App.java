package com.GDSoft;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JSONObject obj1 = new JSONObject();

        obj1.put("name", "foo");
        obj1.put("num", new Integer(100));
        obj1.put("balance", new Double(1000.21));
        obj1.put("is_vip", new Boolean(true));
        obj1.put("samplearr",new int[]{5,6});

        System.out.print(obj1);

        JSONParser parser = new JSONParser();
        String s = "[0,{\"1\":{\"2\":{\"3\":{\"4\":[5,{\"6\":7}]}}}}]";

        try{
            Object obj = parser.parse(s);
            JSONArray array = (JSONArray)obj;

            System.out.println("\nThe 2nd element of array");
            System.out.println(array.get(1));
            System.out.println();

            JSONObject obj2 = (JSONObject)array.get(1);
            System.out.println("Field \"1\"");
            System.out.println(obj2.get("1"));

            s = "{}";
            obj = parser.parse(s);
            System.out.println(obj);

            s = "[5,]";
            obj = parser.parse(s);
            System.out.println(obj);

            s = "[5,,2]";
            obj = parser.parse(s);
            System.out.println(obj);
        }catch(ParseException pe){

            System.out.println("position: " + pe.getPosition());
            System.out.println(pe);
        }
    }
}
