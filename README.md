#QRModule
* 抽出https://github.com/chentao0707/SimplifyReader里的二维码扫描模块(暂未加入图片上传识别二维码)

* 根目录是个DEMO,使用方法只需直接复制导入根目录下的QRModule文件夹即可,
* 建议在app的gradle里添加如下代码过滤.so文件,通用的只要有armeabi即可,微信就是一个armeabi走天下

		android {
		    defaultConfig {
				ndk {
		            //cpu.so
		            abiFilters 'armeabi-v7a'
		            //'x86', 'x86_64', 'mips', 'mips64'
		        }
			}
		}
