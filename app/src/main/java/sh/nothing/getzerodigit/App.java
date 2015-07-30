package sh.nothing.getzerodigit;

import android.app.Application;

import com.deploygate.sdk.DeployGate;

public class App extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        DeployGate.install(this, null, true);
    }
}
