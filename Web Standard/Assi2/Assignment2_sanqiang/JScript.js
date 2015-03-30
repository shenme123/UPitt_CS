//Up movement
function Up() {
    if (document.getElementById('Up').childNodes.length >0) {
        var del = document.getElementById('Up').childNodes[0];
        document.getElementById('Up').removeChild(del);
        ReportNode();
    }
}
//Down movement
function Down() {
    if (document.getElementById('Up').childNodes.length <13) {
        var e = document.createElement("br");
        document.getElementById('Up').appendChild(e);
        ReportNode();
    }
}
//left movement
function Left() {
    if (document.getElementById('Left').childNodes.length > 0) {
    var del = document.getElementById('Left').childNodes[0];
    document.getElementById('Left').removeChild(del);
    ReportNode();
    }
}
//right movement
function Right() {
    if (document.getElementById('Left').childNodes.length < 39) {
        var e = document.createElement("span");
        //e.style.float = 'left';
        e.innerHTML = '&nbsp;&nbsp;&nbsp;';
        document.getElementById('Left').appendChild(e);
        ReportNode();
    }
}
//keydown event
document.onkeydown = function (e) {
    if (document.all) {
        var e = event.keyCode;//document.all verify that is IE
    } else {
        var e=e.keyCode  //others will be firefox and other browers
    }
    switch (e) {
        case 38:
            Up();
            break;
        case 40:
            Down();
            break;
        case 37:
            Left();
            break;
        case 39:
            Right();
            break;
    }
}
//Report path I have done
function ReportNode() {
    var items = document.getElementById('Left').childNodes;
    var text = "";
    for (var i = 0; i < items.length; i++) {
        text += "Right One Time,&nbsp;";
    }
    text+="<br />"
    var items = document.getElementById('Up').childNodes;
    for (var i = 0; i < items.length; i++) {
        text += "Down One Time,&nbsp;";
    }
    document.getElementById('show').innerHTML = text;
}
//Randomly move
function MoveRandom() {
    var move = Math.ceil(Math.random() * 4);
    switch (move) {
        case 4:
            Up();
            break;
        case 1:
            Down();
            break;
        case 2:
            Left();
            break;
        case 3:
            Right();
            break;
    }
}
var flag = true;
//start random move
function StartMove() {
    if (flag) {
        e = setInterval("MoveRandom()", 100);
        flag = false;
        document.getElementById('RandomMovement').value = "Stop Movement";
    }
    else {
        clearInterval(e);
        flag = true;
        document.getElementById('RandomMovement').value = "Start Movement";
    }
}
//Add one more robot
var robot_arr = new Array(3);
robot_arr[0] = "peo1.jpg";
robot_arr[1] = "peo2.jpg";
robot_arr[2] = "peo3.jpg";
function Addone() {
    var ori = document.getElementById('Android').cloneNode(false);
    ori.setAttribute("src", "Image/" + robot_arr[Math.floor(Math.random() * 3)]);
    
    document.getElementById('Android').parentNode.appendChild(ori);

}
//Random change Pic
var pic_arr = new Array(11);
pic_arr[0] = "0.gif";
pic_arr[1] = "1.gif";
pic_arr[2] = "2.gif";
pic_arr[3] = "3.gif";
pic_arr[4] = "4.gif";
pic_arr[5] = "5.gif";
pic_arr[6] = "6.gif";
pic_arr[7] = "7.gif";
pic_arr[8] = "8.gif";
pic_arr[9] = "9.gif";
pic_arr[10] = "10.gif";
function RandomPic() {
    document.getElementById('ShowImage').src = "Image/" + pic_arr[Math.round(Math.random() * 10)];
}
//Time relate 
function getTime(target) {
    var obj = new Date();
    document.getElementById(target).innerHTML = obj.getHours() + ":" + obj.getMinutes() + ":" + obj.getSeconds();
}

