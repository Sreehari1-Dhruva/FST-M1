# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
  
  # Open the browser to the URL
    driver.get("https://training-support.net/webelements/login-form/")
    print("The Page title is : ",driver.title)

    driver.find_element(By.ID,"username").send_keys("admin")
    driver.find_element(By.ID,"password").send_keys("password")
    driver.find_element(By.XPATH,"//div/main/div/div/div/div/div[2]/form/button").click()

    print("New Page title is : ",driver.title)
    driver.quit()