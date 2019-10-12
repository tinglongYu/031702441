#!/usr/bin/env python 
# -*- coding:utf-8 -*-
from flask import Flask
from flask import request
from flask import render_template
from flask import make_response, redirect, url_for
from flask import jsonify
from werkzeug.utils import secure_filename
from os import path
import json
import datetime

import PlayCards

app = Flask(__name__)

wsgi_app = app.wsgi_app

@app.route('/')
@app.route('/index')
def home():
    message = {"flag":"hello world!"}
    return json.dumps(message,ensure_ascii=False)


 #图片上传函数
@app.route("/card_division",methods=['GET','POST'])
def card_division():
    message = {
        "card":[
            "123",
            "456",
            "789"
        ]
    }
    card_string = []
    json_data = request.get_json()
    print(json_data)
    print(json_data["cardstring"])
    card_string = json_data["cardstring"]
    message["card"] = shisanshui.main_function(card_string)
    return json.dumps(message,ensure_ascii=False)


if __name__ == '__main__':
    app.config['JSON_AS_ASCII'] = False
    app.run(host='0.0.0.0', port=8080)    #外网访问，端口号为8080