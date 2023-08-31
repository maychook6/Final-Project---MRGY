import requests
import time

def send_get_request(url):
    response = requests.get(url)
    if response.status_code == 200:
        print(f"GET request to {url} successful")
    else:
        print(f"GET request to {url} failed with status code: {response.status_code}")

    target_url = "'http://localhost:8000/OurApp'"
    while True:
        send_get_request(target_url)
        time.sleep(60)
