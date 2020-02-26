package com.example.springboot.enumX;

public enum Color {
    Red("red",1),Blue("blue",2),Yellow;

    private String name;
    private int index;

    private Color(){}
    private Color(String name,int index){
        this.name = name;
        this.index = index;
    }

    public String getName(){
        return this.name;
    }

    public int getIndex(){
        return this.index;
    }

}

