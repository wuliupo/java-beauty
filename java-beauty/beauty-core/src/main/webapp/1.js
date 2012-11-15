		function submit()
		{
			window.document.getElementById("loginForm").submit();
		}
		/*
		//自动执行的匿名函数，主要为了防止多个js文件里定义同样的变量导致全局变量重复冲突。
		(function() {
		 
		    //获得当前选中的tab，下面将向这个tab添加模块组件
		    var activeTab = Ext.getCmp("center-panel").getActiveTab();
		 
		    //创建一个按钮用来弹出一个模态窗体
		    var btn = Ext.widget('button', {
		        //renderTo: activeTab.id,
		        style: 'margin-left: 8px;margin-top:8px;',
		        text: '点击弹出一个窗口',
		        width:120,
		        height:30,
		        handler: function () {
		            Ext.widget('window', {
		                title: '一个Extj窗口',
		                closeAction: 'hide',
		                width: 400,
		                height: 300,
		                layout: 'fit',
		                resizable: true,
		                modal: true,
		                html:'<p>一般这个窗口里放form表单等控件</p>'
		            }).show();
		        }
		    });
		 
		    //向tab里添加一个按钮
		    activeTab.add(btn);
		 
		})();
		*/