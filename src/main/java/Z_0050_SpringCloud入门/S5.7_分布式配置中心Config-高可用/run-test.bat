
::echo %~dp0
::cd /d %~dp0\E1_����ע������
::START mvn spring-boot:run 
:: TIMEOUT /T 5


START "K1_����ע������" /D %~dp0\K1_����ע������ mvn clean compile spring-boot:run
TIMEOUT /T 15
START "K2_��������A" /D %~dp0\K2_��������A mvn clean compile spring-boot:run
START "K2_��������B" /D %~dp0\K2_��������B mvn clean compile spring-boot:run
TIMEOUT /T 60
START "K3_�ͻ���" /D %~dp0\K3_�ͻ��� mvn clean compile test