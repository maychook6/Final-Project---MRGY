# Generated by Selenium IDE
from telnetlib import EC
import pytest
import time
import json
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support import expected_conditions
from selenium.webdriver.support.wait import WebDriverWait
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.desired_capabilities import DesiredCapabilities
from selenium.webdriver.firefox.options import Options

class TestFinelProjectTest():
  def setup_method(self, method):
    self.driver = webdriver.Chrome()
    self.vars = {}
  
  def test_finelProjectTest(self):
    self.driver.get("http://localhost:8000/OurApp/")
    try:
      element = WebDriverWait(self.driver, 10).until(
          EC.presence_of_element_located((By.ID, "MRGY"))
      )
    except: 
      WebDriverWait(self.driver,10)

    self.driver.set_window_size(1058, 804)
    self.driver.find_element(By.ID, "gil_in").click()
    self.driver.find_element(By.ID, "gil_in").send_keys("100")
    self.driver.find_element(By.ID, "gil_btn").click()
    assert self.driver.find_element(By.ID, "gil_grade").text == "100"
    self.driver.find_element(By.ID, "may_in").click()
    self.driver.find_element(By.ID, "may_in").send_keys("100")
    self.driver.find_element(By.ID, "may_btn").click()
    assert self.driver.find_element(By.ID, "may_grade").text == "100"
    self.driver.find_element(By.ID, "reuven_in").click()
    self.driver.find_element(By.ID, "reuven_in").send_keys("100")
    self.driver.find_element(By.ID, "reuven_btn").click()
    assert self.driver.find_element(By.ID, "reuven_grade").text == "100"
    self.driver.find_element(By.ID, "yair_in").click()
    self.driver.find_element(By.ID, "yair_in").send_keys("100")
    self.driver.find_element(By.ID, "yair_btn").click()

  def teardown_method(self, method):
    self.driver.quit()  
