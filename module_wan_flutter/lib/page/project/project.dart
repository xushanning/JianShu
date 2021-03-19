import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:module_wan_flutter/page/project/project_model.dart';
import 'package:module_wan_flutter/widgets/search_head.dart';
import 'package:provider/provider.dart';

class ProjectPage extends StatelessWidget {
  final String name;

  ProjectPage({this.name = "这是project页面"});

  @override
  Widget build(BuildContext context) {
    return ChangeNotifierProvider<ProjectModel>(
      create: (_) => ProjectModel(),
      builder: (context, child) {
        ProjectModel _model = Provider.of(context, listen: true);

        return Scaffold(
            body: SearchHead("cechishidfosdf"),
        );
      },
    );
  }
}
