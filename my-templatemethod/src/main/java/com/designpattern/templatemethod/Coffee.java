package com.designpattern.templatemethod;

public class Coffee extends CaffeineBaverage{
    public Coffee(){

    }
    public void brew(){
        System.out.println("Dripping Coffee through filter");

    }
    public void addCondiments(){
        System.out.println("Adding Sugar and Milk");

    }

    public boolean customerWantsCondiments(){
        String answer = getUserInput();
        if(answer.toLowerCase().startsWith("y")){
            return true;
        } else {
            return false;
        }
    }
    private String getUserInput(){
        String answer = null;

        System.out.print("Would you like ... ");
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        try{
            answer = in.readLine();
        } catch(IOException ioe){
            System.err.println("IOError");
        }
        if (answer == null) {
            return "no";
        }
        return answer;
    }
}