import 'package:json_annotation/json_annotation.dart';

part 'banner_bean.g.dart';
///https://blog.csdn.net/xudailong_blog/article/details/95168949

@JsonSerializable()
class BannerBean extends Object {

  @JsonKey(name: 'desc')
  String desc;

  @JsonKey(name: 'id')
  int id;

  @JsonKey(name: 'imagePath')
  String imagePath;

  @JsonKey(name: 'isVisible')
  int isVisible;

  @JsonKey(name: 'order')
  int order;

  @JsonKey(name: 'title')
  String title;

  @JsonKey(name: 'type')
  int type;

  @JsonKey(name: 'url')
  String url;

  BannerBean(this.desc,this.id,this.imagePath,this.isVisible,this.order,this.title,this.type,this.url,);

  factory BannerBean.fromJson(Map<String, dynamic> srcJson) => _$BannerBeanFromJson(srcJson);

  Map<String, dynamic> toJson() => _$BannerBeanToJson(this);

}
