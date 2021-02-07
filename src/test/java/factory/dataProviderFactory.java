package factory;

import dataprovider.configDataProvider;
import dataprovider.excelDataProvider;

public class dataProviderFactory {
    public static configDataProvider getConfig()
    {
        configDataProvider config= new configDataProvider();
        return config;
    }
    public static excelDataProvider getExcel()
    {
        excelDataProvider excel= new excelDataProvider();
        return excel;
    }

}
