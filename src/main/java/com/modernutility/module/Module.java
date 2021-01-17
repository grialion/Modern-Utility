package com.modernutility.module;

public class Module {

    private String name;
    private int bind;
    private Category category;
    private boolean isEnabled;

    public Module(String name, int bind, Category category)
    {
        this.name = name;
        this.bind = bind;
        this.category = category;

        // We create a callable class -> we can create instance of it
    }

    public String getName() {
        return name;
    }

    public int getBind() {
        return bind;
    }

    public Category getCategory() {
        return category;
    }

    public boolean getState() {
        return isEnabled;
    }

    public void setState(boolean state)
    {
        this.onToggle();
        if(state){
            this.onEnable();
            this.isEnabled = true;
        }else{
            this.onDisable();
            this.isEnabled = false;
        }
    }

    private void onDisable() { }

    private void onEnable() { }

    private void onToggle() { }

    public void toggleModule()
    {
        this.setState(!this.getState());
    }
}
