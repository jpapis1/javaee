package app.service;

import app.domain.Settings;

import java.util.ArrayList;
import java.util.List;

public class SettingsService {
    private List<Settings> allSettings = new ArrayList<>();
    public static int counter = 0;
    public void addToSettings(Settings settings) {
        allSettings.add(settings);
        counter++;
        settings.setId(counter);
    }
    public void deleteSetting(int id) {

        allSettings.remove(id);
    }
    public void removeFromSettings(Settings settings) {
        allSettings.remove(settings);
    }
    public List<Settings> getSettings() {
        return allSettings;
    }
}
