# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
  
  # Open the browser to the URL
  driver.get("https://training-support.net")
  print("The Page title is : ",driver.title)

  driver.find_element(By.LINK_TEXT, "About Us").click()
  print("New Page title is : ",driver.title)
  driver.quit()