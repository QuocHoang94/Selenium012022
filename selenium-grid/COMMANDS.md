## Command to start Hub
```
java -jar /Users/tuhuynh/SOURCE_CODE/k4-selenium/selenium-grid/selenium-server-4.1.2.jar hub
```

## Command to start Node
This node will register:
* Chrome
* Firefox
* Safari

Note: IF you are on Windows OS, please remove part related to safari and add for Edge
```
java -jar -Dwebdriver.<type>.<name>s path/to/selenium/server.jsr node --config /path/to/nodeConfig.json
java -jar -Dwebdriver.gecko.driver=/Users/tuhuynh/SOURCE_CODE/k4-selenium/selenium-grid/geckodriver -Dwebdriver.chrome.driver=/Users/tuhuynh/SOURCE_CODE/k4-selenium/selenium-grid/chromedriver /Users/tuhuynh/SOURCE_CODE/k4-selenium/selenium-grid/selenium-server-4.1.2.jar node --config /Users/tuhuynh/SOURCE_CODE/k4-selenium/selenium-grid/node_config.json

```

NOTE: on Windows need to specify extension like gecko.exe, chrome.exe

## Next
In second stage, we will learn about how to set up using Docker