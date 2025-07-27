## 🚀 Selenium Automation – Implementing IRetryAnalyzer for Rerunning Failed Tests Automatically

Automated test execution isn’t always perfect — occasional flakiness can result from network delays, environment issues, or timing mismatches. To make my hands-on Selenium TestNG framework more robust, I’ve integrated IRetryAnalyzer to automatically re-run failing test cases. A small addition, but important one.

---

### 📂 Project Structure:

<img width="476" height="847" alt="01_Project_Structure" src="https://github.com/user-attachments/assets/56514ceb-0948-4f22-b6cc-45e0ebe7b72b" />

---

### 🔍 What I’ve Achieved:
1. Automatic reruns for failed tests with a configurable retry limit
2. Reduced false negatives caused by flaky test behavior
3. Improved test reliability and CI/CD pipeline stability
4. Centralized retry configuration using a properties file

---

### 🔧 Steps Taken:
1. Created RetryTests class implementing IRetryAnalyzer  
<img width="1473" height="469" alt="02_RetryTestClass" src="https://github.com/user-attachments/assets/09e042dc-a8b9-4a9e-93ad-aee1f6062ad2" />  

2. Built RetryTransformer class using IAnnotationTransformer  
<img width="1473" height="252" alt="03_RetryTransformer" src="https://github.com/user-attachments/assets/4fcf157e-55d0-4021-89e6-dcaeeb712cfa" />  

3. Registered the transformer in testng.xml:  
<img width="1473" height="345" alt="04_testngxml" src="https://github.com/user-attachments/assets/9bcb7547-f129-464b-8edf-5e0b10f20cd7" />

4. Used ConfigReader to manage retry attempts via properties file  
<img width="1473" height="193" alt="05_config_properties" src="https://github.com/user-attachments/assets/b2c3e566-7be1-467c-9488-3149c4728bf9" />  

---

### Reports:
<img width="1920" height="1032" alt="06_Reports1" src="https://github.com/user-attachments/assets/e6d7ece0-a1cb-452f-bf54-9fd53306a4b4" />  
<img width="1920" height="1032" alt="06_Reports2" src="https://github.com/user-attachments/assets/7b059b2f-f82a-4ece-a6df-9cc1840d5a19" />  
<img width="1920" height="1032" alt="06_Reports3" src="https://github.com/user-attachments/assets/59278fa6-17cd-4cc6-9a1f-f3f517e638c1" />  
<img width="1920" height="1032" alt="06_Reports4" src="https://github.com/user-attachments/assets/fec46fb3-3312-41ec-a6bd-46a9314327ef" />  

---

### Logs:
<img width="1920" height="1009" alt="07_Logs" src="https://github.com/user-attachments/assets/d935e681-4581-4fee-9f07-47227ddcfe32" />  

---

### ✅ Benefits:
- Boosts trust in automation by minimizing flaky failures  
- Makes retry behavior configurable and reusable  

---

### ▶️ Steps to Run This Project:
1. Create and Clone the project to selenium-automation-rerun-failing-test-using-iretryanalyzer folder
```
git clone https://github.com/amulsinfal/selenium-automation-rerun-failing-test-using-iretryanalyzer.git
```
2. Go to the folder selenium-automation-rerun-failing-test-using-iretryanalyzer containing the testng.xml file
```
cd selenium-automation-rerun-failing-test-using-iretryanalyzer
```
3. Open command prompt from this location and Run maven command in command prompt.
```
mvn test
```

<img width="1080" height="1872" alt="" src="https://github.com/user-attachments/assets/72de961f-846f-4636-b617-385a208e38cd" />  
<img width="1080" height="1872" alt="" src="https://github.com/user-attachments/assets/6886c2de-1a86-44d1-b462-c32f56fd2933" />  

---

### 📌 Conclusion:
Integrating IRetryAnalyzer has significantly strengthened the Selenium TestNG framework by reducing the impact of flaky test behavior and improving overall test reliability. With a centralized and configurable retry mechanism. 
