import 'package:flutter/material.dart';
import 'package:module_wan_flutter/net/http_request.dart';
import 'package:module_wan_flutter/net/net_util.dart';

///代码千万行，注释第一行，代码不规范，同事两行泪
void main() => runApp(new MaterialApp(
      title: "title",
      theme: ThemeData(primarySwatch: Colors.blue),
      home: new TutorialHome(),
    ));

class MyScaffold extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Material(
      child: new Column(
        children: [
          new MyAppBar(
            title: new Text("这是title"),
          ),
          new Expanded(
            child: new Center(
              child: new Text("hello world"),
            ),
          )
        ],
      ),
    );
  }
}

class MyAppBar extends StatelessWidget {
  MyAppBar({this.title});

  Widget title;

  @override
  Widget build(BuildContext context) {
    return new Container(
      height: 56,
      padding: const EdgeInsets.symmetric(horizontal: 8.0),
      decoration: new BoxDecoration(color: Colors.blue[500]),
      child: new Row(
        children: [
          new IconButton(
            icon: new Icon(Icons.menu),
            onPressed: null,
            tooltip: "menu",
          ),
          new Expanded(
            child: title,
          ),
          new IconButton(
            icon: new Icon(Icons.search),
            tooltip: 'Search',
            onPressed: null,
          )
        ],
      ),
    );
  }
}

class TutorialHome extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        leading: new IconButton(
          icon: new Icon(Icons.add),
          tooltip: "dddd",
          onPressed: null,
        ),
        title: new Text("title"),
        actions: [
          new IconButton(
            icon: new Icon(Icons.search),
            tooltip: "点击",
            onPressed: null,
          )
        ],
      ),
      body: new Center(
        child: new Text("hello world"),
      ),
      floatingActionButton: new FloatingActionButton(
        child: new Icon(Icons.add),
        onPressed: null,
      ),
    );
  }
}
