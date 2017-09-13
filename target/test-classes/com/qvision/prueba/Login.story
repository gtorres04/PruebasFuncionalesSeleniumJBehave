Como usuario quiero autenticarme para que el sistema identifique quien soy

Given La pagina de login http://sahitest.com/demo/training/login.htm
When campo user digite test
And campo password digite secret
And y presione el boton con class button
Then redireccionar a la pagina con titulo Books

Given La pagina de login http://sahitest.com/demo/training/login.htm
When campo user digite userError
And campo password digite secretError
And y presione el boton con class button
Then redireccionar a la pagina con titulo Login