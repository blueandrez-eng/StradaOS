package com.stradaos.launcher;

import android.content.SharedPreferences;

/**
 * Preferencias iniciales de VersaDrive Prueba.
 * Solo se ejecutan la primera vez; nunca sobrescribe ajustes posteriores.
 * No modifica el launcher FYT ni activa permisos o servicios del vehículo.
 */
final class VersaDriveSetup {
    private VersaDriveSetup() { }

    static void seed(SharedPreferences prefs) {
        if (prefs.getBoolean("versadrive_seeded_v1", false)) return;

        SharedPreferences.Editor e = prefs.edit();
        if (!prefs.contains("car_name")) e.putString("car_name", "Nissan Versa 2014");
        if (!prefs.contains("car_tag")) e.putString("car_tag", "VERSADRIVE");
        if (!prefs.contains("accent")) e.putInt("accent", 0xFF3189FF);
        if (!prefs.contains("theme")) e.putString("theme", "dark");
        if (!prefs.contains("speed_unit")) e.putString("speed_unit", "kmh");
        if (!prefs.contains("speedo")) e.putInt("speedo", 2);
        if (!prefs.contains("car_speed")) e.putBoolean("car_speed", true);
        if (!prefs.contains("show_car")) e.putBoolean("show_car", true);
        if (!prefs.contains("show_player")) e.putBoolean("show_player", true);
        // Mantiene el mapa en el centro y coloca el auto a la derecha.
        if (!prefs.contains("player_side")) e.putString("player_side", "left");
        if (!prefs.contains("layout_mode")) e.putString("layout_mode", "horizontal");
        // No presentar un mantenimiento como pendiente si el usuario no lo ha configurado.
        if (!prefs.contains("oil_home")) e.putBoolean("oil_home", false);
        e.putBoolean("versadrive_seeded_v1", true).apply();
    }
}
