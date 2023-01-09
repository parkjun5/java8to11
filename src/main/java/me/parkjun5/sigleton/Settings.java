package me.parkjun5.sigleton;

import java.io.ObjectInput;
import java.io.Serializable;

public class Settings implements Serializable {

    private static class SettingHolder {
        private static final Settings SETTINGS = new Settings();
    }

    private Settings() { }

    public static Settings getInstance() {
        return SettingHolder.SETTINGS;
    }

    protected Object readResolve() {
        return getInstance();
    }

}
