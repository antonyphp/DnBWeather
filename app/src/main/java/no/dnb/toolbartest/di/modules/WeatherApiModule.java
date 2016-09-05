package no.dnb.toolbartest.di.modules;

import dagger.Module;
import dagger.Provides;
import no.dnb.toolbartest.di.scopes.UserScope;
import no.dnb.toolbartest.webservice.WeatherApiInterface;
import retrofit2.Retrofit;

@Module
public class WeatherApiModule {

    @Provides
    @UserScope
    public WeatherApiInterface providesWeatherApiInterface(Retrofit retrofit) {
        return retrofit.create(WeatherApiInterface.class);
    }
}
