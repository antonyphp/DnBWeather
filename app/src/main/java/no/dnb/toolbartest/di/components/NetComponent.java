package no.dnb.toolbartest.di.components;



import javax.inject.Singleton;

import dagger.Component;
import no.dnb.toolbartest.di.modules.AppModule;
import no.dnb.toolbartest.di.modules.NetModule;
import retrofit2.Retrofit;

@Singleton
@Component(modules={AppModule.class,NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}