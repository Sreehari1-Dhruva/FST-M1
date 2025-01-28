# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
  
  # Open the browser to the URL
    driver.get("https://training-support.net/webelements/login-form/")
    print("The Page title is : ",driver.title)

    driver.find_element(By.XPATH,"//input[@type='text']").send_keys("admin")
    driver.find_element(By.XPATH,"//input[@type='password']").send_keys("password")
    driver.find_element(By.XPATH,"//button[text()='Submit']").click()

    print("New Page title is : ",driver.title)
    driver.quit()