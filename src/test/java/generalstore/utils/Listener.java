package generalstore.utils;

import com.aventstack.extentreports.Status;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import static generalstore.utils.ConfigReader.getProperty;
import static generalstore.utils.Driver.*;
import static generalstore.utils.ExtentReport.*;

public class Listener implements ITestListener {
    @Override
    public void onStart(ITestContext context) {
        serverBaslat(getProperty("localIPAdres"), Integer.parseInt(getProperty("localPort")));
        raporOlustur();
    }

    @Override
    public void onTestStart(ITestResult result) {
        testOlustur(result.getMethod().getMethodName());
        test.info("Test başladı.");
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test başarıyla tamamlandı.");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Hata mesajı
        test.fail("Test başarısız oldu. Çünkü: " + result.getThrowable().getMessage());

        // Ekran Görüntüsü alma
//        File dosya = driver.getScreenshotAs(OutputType.FILE);
//        String dosyaYolu = System.getProperty("user.dir") + File.separator + "raporlar" + File.separator + result.getMethod().getMethodName() + ".png";
//        try {
//            FileUtils.copyFile(dosya, new File(dosyaYolu));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
// C:\Users\Yusuf\IdeaProjects\AppiumTestNGFramework\src\test\resources\General-Store.apk
        // Ekran görüntüsünü rapora ekleme
//        try {
//            test.addScreenCaptureFromPath(dosyaYolu);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        uygulamayiKapat();
    }

    @Override
    public void onFinish(ITestContext context) {
        uygulamayiKapat();
        raporuKaydet();
        serverKapat();
    }
}























