import 'package:flutter/cupertino.dart';

class HomeProvider with ChangeNotifier{

  void update(){
    notifyListeners();
  }
}