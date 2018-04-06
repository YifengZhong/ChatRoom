import { Component, OnInit } from '@angular/core';
import { ConnectService } from "../service/connectionSrv";

@Component({
  selector: 'connect-component',
  templateUrl: './connect-component.component.html',
  styleUrls: ['./connect-component.component.css']
})
export class ConnectComponentComponent implements OnInit {

  username: "";
  toUser:string;
  public items = [];
  hideorShow:boolean;
  showErrorMsg:boolean;
  message_content:string;
  activeList = [];
  isActive:boolean;
  connect_address:string;
  constructor(public connect: ConnectService) {
    this.hideorShow=false;
    this.showErrorMsg=false;
   }

  ngOnInit() {
    this.isActive = false;
    this.connect_address = "localhost:8080/gs-guide-websocket";
    this.toUser = "";
  }
  onSubmit(form) {
    console.log(this.activeList.length);
    if(this.activeList.length > 10) {
      this.showErrorMsg = true;
    }
    this.connect.login(this.username);
  }
  onDisconnect() {
    this.connect.disConnect(this.username);
    this.hideorShow = false;
  }
  onSend() {

    this.connect.send(this.username,this.message_content,this.toUser);
    this.message_content = "";
    
  }
  onConnect() {
    this.hideorShow = true;
    this.showErrorMsg = false;
    this.connect.connect(this.connect_address).subscribe(data => {
      if(data.full === true) {
        this.hideorShow = false;
        this.showErrorMsg = true;
        return;
      }
      console.log("data", data);
      if(data.list !== undefined) {
        console.log("get activeList", data.list);
        this.activeList = data.list;
        this.isActive = true;
        return;
      }
      let receiver = "";
      console.log("success2", data.toUser);
      if(data.toUser !== "") {
        receiver = "@" + data.toUser;
      }
      this.items.unshift({sender:data.name+":",toUser:receiver, message:data.content});

      this.toUser="";
    });;   
  }
  showError() {
      if(this.showErrorMsg===false) {
        return "hideParts";
      } else {
        return "errorMsg showParts";
      }
  }
  getClaz() {
    if(this.hideorShow) {
      return "addParts";
      
    } else {
      return "hideParts";
    }
  }
  getsubmitClass() {
    if(this.hideorShow) {
      return "hideParts";
      
    } else {
      return "addParts";
    }    
  }
  setClickedRow(i) {
    this.toUser=this.activeList[i];
  }
}
