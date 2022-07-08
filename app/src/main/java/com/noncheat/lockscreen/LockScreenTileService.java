package com.noncheat.lockscreen;

import android.content.Intent;
import android.os.Build;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

import androidx.annotation.RequiresApi;

@RequiresApi(api = Build.VERSION_CODES.N)
public class LockScreenTileService extends TileService {
    @Override
    public void onClick() {
        super.onClick();
        Intent mainIntent = new Intent(this, MainActivity.class);
        mainIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityAndCollapse(mainIntent);
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        updateTile();
    }

    void updateTile() {
        Tile tile = getQsTile();
        if (tile != null) {
            tile.setState(Tile.STATE_INACTIVE);
            tile.updateTile();
        }
    }
}
