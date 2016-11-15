#QRModule
* 抽出https://github.com/chentao0707/SimplifyReader里的二维码扫描模块(暂未加入图片上传识别二维码)

* 根目录是个test,使用只需直接复制导入QRModule文件夹即可,可在app的manifest里添加如下代码过滤.so文件,通用的只要有armeabi即可,微信就是一个armeabi走天下

		android {
		    defaultConfig {
				ndk {
		            //cpu.so
		            abiFilters 'armeabi-v7a'
		            //'x86', 'x86_64', 'mips', 'mips64'
		        }
			}
		}

	######三星S6加入如上过滤后APP大小
	* 空APP占10.80M
	* 加入module的占21.89M
	* app的gradle过滤.so文件后14.61M
