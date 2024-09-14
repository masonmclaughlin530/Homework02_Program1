package com.example.homework02_program1;

public class ColorInfo
{
    //red, green, blue, hexadecimal
    private int red;
    private int green;
    private int blue;
    private String hex;

    //constructor
    public ColorInfo()
    {

    }

    //overloaded
    public ColorInfo(int r, int g, int b, String h)
    {
        red = r;
        green = g;
        blue = b;
        hex = h;
    }

    //getters and setters

    public int getGreen()
    {
        return green;
    }

    public void setGreen(int green)
    {
        this.green = green;
    }

    public int getRed()
    {
        return red;
    }

    public void setRed(int red)
    {
        this.red = red;
    }

    public int getBlue()
    {
        return blue;
    }

    public void setBlue(int blue)
    {
        this.blue = blue;
    }

    public String getHex()
    {
        return hex;
    }

    public void setHex(String hex)
    {
        this.hex = hex;
    }


}
