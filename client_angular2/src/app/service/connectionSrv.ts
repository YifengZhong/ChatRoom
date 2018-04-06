import { Injectable } from '@angular/core';
import {Subject} from 'rxjs/Subject';
import {Observable} from 'rxjs/Observable';
import 'stompjs';
declare let Stomp:any;

@Injectable()
export class ConnectService {
    private _stompClient;
    private _stompSubject : Subject<any> = new Subject<any>();
    public  delay(ms: number) {
        return new Promise( resolve => setTimeout(resolve, ms) );
    }
    public login(_name:string) {
        console.log(_name);
        this._stompClient.send("/app/login", {}, JSON.stringify({'fullName': _name}));

    }
    public connect(address: string):Observable<any> {
        let self = this;
        let webSocket = new WebSocket("ws://"+ address + '/websocket');
        this._stompClient = Stomp.over(webSocket);
        this._stompClient.connect({}, function (frame) {

            self._stompClient.subscribe('/topic/messaging', function (stompResponse) {
                // stompResponse = {command, headers, body with JSON 
                // reflecting the object returned by Spring framework}
                self._stompSubject.next(JSON.parse(stompResponse.body));
                
            });
            self._stompClient.subscribe('/topic/login', function (stompResponse) {
                // stompResponse = {command, headers, body with JSON 
                // reflecting the object returned by Spring framework}
                console.log("get the feedback",JSON.parse(stompResponse.body));
                self._stompSubject.next(JSON.parse(stompResponse.body));
                //self._stompSubject.next(JSON.parse(stompResponse.body));
                
            });
            
        },function(err) {
            self._stompSubject.next(1);
        });
        return self._stompSubject;
    }
    public disConnect(username:string) {
        console.log("ccc");
        this._stompClient.send("/app/logout", {}, JSON.stringify({'fullName': username}))
        if (this._stompClient !== null) {
            this._stompClient.disconnect();
          }
      
    }

    public send(username:string, _payload: string,toUser:string) {
        //TODO get name
        console.log("abc",toUser);
        this._stompClient.send("/app/messaging", {}, JSON.stringify({'name': username,'content':_payload,'toUser':toUser}));
    }

    public getObservable() : Observable<any> {
        return this._stompSubject.asObservable();
    }
     
}