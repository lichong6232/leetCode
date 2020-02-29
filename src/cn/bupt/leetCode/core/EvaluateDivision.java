package cn.bupt.leetCode.core;

import java.util.*;

/**
 * @Author: lichong04
 * @Date: Created in 下午4:43 2019/8/16
 */
public class EvaluateDivision {

    /**
     * Equations are given in the format A / B = k, where A and B are variables represented as strings, and k is a real number (floating point number). Given some queries, return the answers. If the answer does not exist, return -1.0.

     Example:
     Given a / b = 2.0, b / c = 3.0.
     queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
     return [6.0, 0.5, -1.0, 1.0, -1.0 ].

     The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries , where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

     According to the example above:

     equations = [ ["a", "b"], ["b", "c"] ],
     values = [2.0, 3.0],
     queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].


     The input is always valid. You may assume that evaluating the queries will result in no division by zero and there is no contradiction.
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,String> parent = new HashMap<>();
        Map<String,Double> value = new HashMap<>();
        double[] result = new double[queries.size()];
        for (int i=0;i<values.length;i++){
            String op1 = equations.get(i).get(0);
            String op2 = equations.get(i).get(1);
            parent.put(op1,op1);
            parent.put(op2,op2);
            value.put(op1,1D);
            value.put(op2,1D);
        }
        for (int i=0;i<values.length;i++){
            union(equations.get(i).get(0),equations.get(i).get(1),parent,value,values[i]);
        }

        for (int i=0;i<queries.size();i++){
            List<String> query = queries.get(i);
            String op1 = query.get(0);
            String op2 = query.get(1);
            if(!parent.containsKey(op1) || !parent.containsKey(op2)){
                result[i] = -1;
            }else if (!parent(op1,parent).equals(parent(op2,parent))){
                result[i] = -1;
            }else {
                result[i] = value.get(op1)/value.get(op2);
            }
        }
        System.out.println("value:"+value);
        return result;
    }

    public static void main(String[] args) {
        EvaluateDivision evaluateDivision = new EvaluateDivision();
        List<List<String>> equations = new ArrayList<>();
        List<String> equation1 = new ArrayList<>();
        equation1.add("a");
        equation1.add("b");
        List<String> equation2 = new ArrayList<>();
        equation2.add("b");
        equation2.add("c");
        equations.add(equation1);
        equations.add(equation2);
        double values[] = new double[]{2.0,3.0};
        List<List<String>> querys = new ArrayList<>();
        List<String> query1= new ArrayList<>();
        query1.add("a");
        query1.add("c");
        List<String> query2= new ArrayList<>();
        query2.add("b");
        query2.add("a");
        List<String> query3= new ArrayList<>();
        query3.add("a");
        query3.add("e");
        List<String> query4= new ArrayList<>();
        query4.add("a");
        query4.add("a");
        List<String> query5= new ArrayList<>();
        query5.add("x");
        query5.add("x");
        querys.add(query1);
        querys.add(query2);
        querys.add(query3);
        querys.add(query4);
        querys.add(query5);
        double[] doubles = evaluateDivision.calcEquation(equations, values, querys);
        System.out.println(Arrays.toString(doubles));

    }

    private String parent(String op1,Map<String,String> parent){
        if (!parent.get(op1).equals(op1)){
            parent.put(op1,parent(parent.get(op1),parent));
        }
        return parent.get(op1);
    }

    private void union(String op1,String op2,Map<String,String> parent,Map<String,Double> value,Double i){
        String parent1 = parent(op1,parent);
        String parent2 = parent(op2,parent);
        if (parent1.hashCode()<parent2.hashCode()){
            double ratio = value.get(op1)/(value.get(op2)*i);
            for (Map.Entry<String,String> entry : parent.entrySet()){
                if (parent(entry.getKey(),parent).equals(parent(op2,parent))){
                    value.put(entry.getKey(),value.get(entry.getKey())*ratio);
                }
            }
            parent.put(op2,op1);
            return;
        }
        if (parent1.hashCode()>parent2.hashCode()){
            double ratio = (value.get(op2)*i)/value.get(op1);
            for (Map.Entry<String,String> entry : parent.entrySet()){
                if (parent(entry.getKey(),parent).equals(parent(op1,parent))){
                    value.put(entry.getKey(),value.get(entry.getKey())*ratio);
                }
            }
            parent.put(op1,op2);
        }
    }


}
