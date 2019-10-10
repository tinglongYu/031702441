#!/usr/bin/env python 
# -*- coding:utf-8 -*-
import flask, json

import flask, json
import PlayCards

server = flask.Flask(__name__)  # __name__代表当前的python文件。把当前的python文件当做一个服务启动

@server.route('/getcards', methods=['post'])  # 第一个参数就是路径,第二个参数支持的请求方式，不写的话默认是get
def getcards():
    card = flask.request.values.get('card')
    output = PlayCards.PostCards(card)
    str_Qiandun = ""
    str_Zhongdun = ""
    str_Houdun = ""
    for item in output[0]:
        str_Qiandun += item[1]
        num = item[0]
        if (num == 11):
            num = 'J'
        elif (num == 12):
            num = 'Q'
        elif (num == 13):
            num = 'K'
        elif (num == 14):
            num = 'A'
        else:
            num = str(num)
        str_Qiandun += num
        str_Qiandun += " "
    str_Qiandun = str_Qiandun[0:len(str_Qiandun) - 1]

    for item in output[1]:
        str_Zhongdun += item[1]
        num = item[0]
        if (num == 11):
            num = 'J'
        elif (num == 12):
            num = 'Q'
        elif (num == 13):
            num = 'K'
        elif (num == 14):
            num = 'A'
        else:
            num = str(num)
        str_Zhongdun += num
        str_Zhongdun += " "
    str_Zhongdun = str_Zhongdun[0:len(str_Zhongdun) - 1]

    for item in output[2]:
        str_Houdun += item[1]
        num = item[0]
        if (num == 11):
            num = 'J'
        elif (num == 12):
            num = 'Q'
        elif (num == 13):
            num = 'K'
        elif (num == 14):
            num = 'A'
        else:
            num = str(num)
        str_Houdun += num
        str_Houdun += " "
    str_Houdun = str_Houdun[0:len(str_Houdun) - 1]
    cardlit=[str_Qiandun,
             str_Zhongdun,
             str_Houdun]
    res = {"card": cardlit}
    return json.dumps(res, ensure_ascii=False)


server.run(port=7777, debug=True, host='0.0.0.0')
