set projectLocation=D:\Balu\Workspace\Applitools_Jenkins
cd %projectLocation%
set classpath=%projectLocation%\bin;
java org.testng.TestNG %projectLocation%\testng.xml
pause