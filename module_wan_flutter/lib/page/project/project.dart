import 'package:flutter/material.dart';
import 'package:flutter/widgets.dart';
import 'package:module_wan_flutter/page/project/project_model.dart';
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
          body: Column(
            children: [
              Text(name),
              Text("${_model.count}"),
              Text(name),
              Text(name),
              Consumer<ProjectModel>(
                builder: (context, notifier, child) {
                  return Text("${notifier.count}");
                },
              ),
              RaisedButton(
                child: Text("点击"),
                onPressed: () => {context.read<ProjectModel>().increase()},
              ),
            ],
          ),
        );
      },
    );
  }
}
