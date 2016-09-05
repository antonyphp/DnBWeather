package no.dnb.toolbartest.di.components;


import dagger.Component;
import no.dnb.toolbartest.activity.DailyForecastFragment;
import no.dnb.toolbartest.activity.HourlyForecastFragment;
import no.dnb.toolbartest.activity.WeatherOverviewFragment;
import no.dnb.toolbartest.di.modules.WeatherApiModule;
import no.dnb.toolbartest.di.scopes.UserScope;

@UserScope
@Component(dependencies = NetComponent.class, modules = WeatherApiModule.class)
public interface WeatherApiComponent {
    void inject(WeatherOverviewFragment weatherOverviewFragment);
    void inject(DailyForecastFragment dailyForecastFragment);
    void inject(HourlyForecastFragment hourlyForecastFragment);
}
