package Bhargav.Marsonia.c301108254;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SharedPreference {
    public static final String PREFS_NAME="HOME_APP";
    public static final String FAVORITES = "Home_Favorite";

    public SharedPreference()
    {
        super();
    }

    public void saveFavorites(Context context, List<MarsoniaApartment> favorites)
    {
        SharedPreferences settings;
        SharedPreferences.Editor editor;

        settings=context.getSharedPreferences(PREFS_NAME,Context.MODE_PRIVATE);
        editor=settings.edit();

        Gson gson=new Gson();
        String jsonFavorites = gson.toJson(favorites);

        editor.putString(FAVORITES,jsonFavorites);
        editor.commit();
    }

    public ArrayList<MarsoniaApartment>getFavorites(Context context)
    {
        SharedPreferences settings;
        List<MarsoniaApartment> favorites;

        settings=context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);

        if(settings.contains(FAVORITES))
        {
            String jsonFavorites = settings.getString(FAVORITES,null);
            Gson gson = new Gson();
            MarsoniaApartment[]favoriteItems = gson.fromJson(jsonFavorites,MarsoniaApartment[].class);

            favorites= Arrays.asList(favoriteItems);
            favorites=new ArrayList<MarsoniaApartment>(favorites);

        }
        else
            return null;
        return (ArrayList<MarsoniaApartment>)favorites;
    }
}
