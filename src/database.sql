USE [onlineshop]
GO

/****** Object:  Table [dbo].[BigClass]    Script Date: 04/28/2016 08:42:07 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[BigClass](
	[bc_id] [char](2) NOT NULL,
	[bc_name] [nvarchar](30) NOT NULL,
 CONSTRAINT [PK_BigClass] PRIMARY KEY CLUSTERED 
(
	[bc_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

USE [onlineshop]
GO

/****** Object:  Table [dbo].[Cancel]    Script Date: 04/28/2016 08:43:00 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Cancel](
	[o_id] [char](13) NOT NULL,
	[cancelreason] [nvarchar](50) NOT NULL,
	[canceltime] [datetime] NOT NULL,
 CONSTRAINT [PK_Cancel] PRIMARY KEY CLUSTERED 
(
	[o_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


USE [onlineshop]
GO

/****** Object:  Table [dbo].[Favorite]    Script Date: 04/28/2016 08:43:12 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Favorite](
	[u_id] [char](16) NOT NULL,
	[p_id] [char](5) NOT NULL,
	[collecttime] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Favorite] PRIMARY KEY CLUSTERED 
(
	[u_id] ASC,
	[p_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


USE [onlineshop]
GO

/****** Object:  Table [dbo].[OrderItem]    Script Date: 04/28/2016 08:43:22 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[OrderItem](
	[o_id] [char](13) NOT NULL,
	[p_id] [char](5) NOT NULL,
	[amount] [smallint] NOT NULL,
	[o_time] [nvarchar](50) NOT NULL,
	[price] [money] NOT NULL,
 CONSTRAINT [PK_OrderItem] PRIMARY KEY CLUSTERED 
(
	[o_id] ASC,
	[p_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[OrderItem]  WITH CHECK ADD  CONSTRAINT [CK_OrderItem_amount] CHECK  (([amount]>=(0)))
GO

ALTER TABLE [dbo].[OrderItem] CHECK CONSTRAINT [CK_OrderItem_amount]
GO


USE [onlineshop]
GO

/****** Object:  Table [dbo].[Product]    Script Date: 04/28/2016 08:43:31 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Product](
	[p_id] [char](5) NOT NULL,
	[p_name] [nvarchar](40) NOT NULL,
	[sc_id] [char](4) NOT NULL,
	[unitprice] [money] NOT NULL,
	[stock] [int] NOT NULL,
	[salesvolume] [int] NOT NULL,
	[evaluationsum] [int] NOT NULL,
	[rq] [int] NOT NULL,
	[score] [float] NULL,
	[smallimg] [nvarchar](50) NOT NULL,
	[other] [nvarchar](50) NULL,
 CONSTRAINT [PK_Product] PRIMARY KEY CLUSTERED 
(
	[p_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FK_Product_SmallClass] FOREIGN KEY([sc_id])
REFERENCES [dbo].[SmallClass] ([sc_id])
GO

ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FK_Product_SmallClass]
GO

ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [CK_Product_evaluationsum] CHECK  (([evaluationsum]>=(0)))
GO

ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [CK_Product_evaluationsum]
GO

ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [CK_Product_rq] CHECK  (([rq]>=(0)))
GO

ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [CK_Product_rq]
GO

ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [CK_Product_salesvolume] CHECK  (([salesvolume]>=(0)))
GO

ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [CK_Product_salesvolume]
GO

ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [CK_Product_score] CHECK  (([score]>=(0) AND [score]<=(5.0)))
GO

ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [CK_Product_score]
GO

ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [CK_Product_stock] CHECK  (([stock]>=(0)))
GO

ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [CK_Product_stock]
GO

ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [CK_Product_unitprice] CHECK  (([unitprice]>=(0)))
GO

ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [CK_Product_unitprice]
GO


USE [onlineshop]
GO

/****** Object:  Table [dbo].[ProductDetail]    Script Date: 04/28/2016 08:43:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[ProductDetail](
	[p_id] [char](5) NOT NULL,
	[brand] [nvarchar](50) NOT NULL,
	[size] [nvarchar](50) NOT NULL,
	[cpjx] [nvarchar](50) NOT NULL,
	[ypfl] [nvarchar](50) NOT NULL,
	[pzwh] [nvarchar](50) NOT NULL,
	[syjl] [nvarchar](50) NOT NULL,
	[expire] [nvarchar](50) NOT NULL,
	[manufacturer] [nvarchar](50) NOT NULL,
	[yf] [nvarchar](50) NOT NULL,
	[detailimg] [nvarchar](200) NOT NULL,
	[description] [text] NULL,
	[syz] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_ProductDetail] PRIMARY KEY CLUSTERED 
(
	[p_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[ProductDetail]  WITH CHECK ADD  CONSTRAINT [CK_ProductDetail_ypfl] CHECK  (([ypfl]='处方药' OR [ypfl]='非处方药'))
GO

ALTER TABLE [dbo].[ProductDetail] CHECK CONSTRAINT [CK_ProductDetail_ypfl]
GO


USE [onlineshop]
GO

/****** Object:  Table [dbo].[Review]    Script Date: 04/28/2016 08:43:49 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[Review](
	[r_id] [nvarchar](100) NOT NULL,
	[u_id] [nvarchar](20) NOT NULL,
	[p_id] [char](5) NOT NULL,
	[score] [float] NOT NULL,
	[imgurl] [nvarchar](50) NULL,
	[r_content] [nvarchar](300) NOT NULL,
	[r_time] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Review] PRIMARY KEY CLUSTERED 
(
	[r_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK_Review_Product] FOREIGN KEY([p_id])
REFERENCES [dbo].[Product] ([p_id])
GO

ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK_Review_Product]
GO

ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [FK_Review_Review_uid] FOREIGN KEY([u_id])
REFERENCES [dbo].[UserInfo] ([u_id])
GO

ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [FK_Review_Review_uid]
GO

ALTER TABLE [dbo].[Review]  WITH CHECK ADD  CONSTRAINT [CK_Review_score] CHECK  (([score]=(1) OR [score]=(2) OR [score]=(3) OR [score]=(4) OR [score]=(5)))
GO

ALTER TABLE [dbo].[Review] CHECK CONSTRAINT [CK_Review_score]
GO


USE [onlineshop]
GO

/****** Object:  Table [dbo].[SendAddr]    Script Date: 04/28/2016 08:43:58 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[SendAddr](
	[addrId] [nvarchar](50) NOT NULL,
	[uid] [nvarchar](20) NOT NULL,
	[addrName] [nvarchar](50) NOT NULL,
	[postcode] [char](6) NOT NULL,
	[cnee] [nvarchar](50) NOT NULL,
	[cnee_tel] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_SendAddr] PRIMARY KEY CLUSTERED 
(
	[addrId] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[SendAddr]  WITH CHECK ADD  CONSTRAINT [FK_SendAddr_UserInfo] FOREIGN KEY([uid])
REFERENCES [dbo].[UserInfo] ([u_id])
GO

ALTER TABLE [dbo].[SendAddr] CHECK CONSTRAINT [FK_SendAddr_UserInfo]
GO


USE [onlineshop]
GO

/****** Object:  Table [dbo].[ShopCart]    Script Date: 04/28/2016 08:44:06 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[ShopCart](
	[u_id] [char](16) NOT NULL,
	[p_id] [char](5) NOT NULL,
	[amount] [smallint] NOT NULL,
	[shoptime] [nvarchar](50) NOT NULL,
	[price] [money] NOT NULL,
 CONSTRAINT [PK_ShopCart] PRIMARY KEY CLUSTERED 
(
	[u_id] ASC,
	[p_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[ShopCart]  WITH CHECK ADD  CONSTRAINT [CK_ShopCart_amount] CHECK  (([amount]>=(1)))
GO

ALTER TABLE [dbo].[ShopCart] CHECK CONSTRAINT [CK_ShopCart_amount]
GO


USE [onlineshop]
GO

/****** Object:  Table [dbo].[SmallClass]    Script Date: 04/28/2016 08:44:14 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[SmallClass](
	[sc_id] [char](4) NOT NULL,
	[sc_name] [nvarchar](30) NOT NULL,
	[bc_id] [char](2) NOT NULL,
 CONSTRAINT [PK_SmallClass] PRIMARY KEY CLUSTERED 
(
	[sc_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[SmallClass]  WITH CHECK ADD  CONSTRAINT [FK_SmallClass_BigClass] FOREIGN KEY([bc_id])
REFERENCES [dbo].[BigClass] ([bc_id])
GO

ALTER TABLE [dbo].[SmallClass] CHECK CONSTRAINT [FK_SmallClass_BigClass]
GO


USE [onlineshop]
GO

/****** Object:  Table [dbo].[UserInfo]    Script Date: 04/28/2016 08:44:22 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[UserInfo](
	[u_id] [nvarchar](20) NOT NULL,
	[pwd] [nvarchar](50) NOT NULL,
	[truename] [nvarchar](50) NOT NULL,
	[sex] [nchar](10) NOT NULL,
	[birthday] [date] NULL,
	[email] [nvarchar](20) NOT NULL,
	[phone] [nvarchar](16) NOT NULL,
	[address] [nvarchar](50) NOT NULL,
	[regtime] [nvarchar](50) NOT NULL,
	[credit] [int] NOT NULL,
	[rank] [smallint] NOT NULL,
	[securityqu1] [nvarchar](50) NOT NULL,
	[securityans1] [nvarchar](50) NOT NULL,
	[securityqu2] [nvarchar](50) NOT NULL,
	[securityans2] [nvarchar](50) NOT NULL,
	[lastlogintime] [nvarchar](50) NULL,
 CONSTRAINT [PK_User] PRIMARY KEY CLUSTERED 
(
	[u_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

ALTER TABLE [dbo].[UserInfo]  WITH CHECK ADD  CONSTRAINT [CK_User_credit] CHECK  (([credit]>=(0)))
GO

ALTER TABLE [dbo].[UserInfo] CHECK CONSTRAINT [CK_User_credit]
GO

ALTER TABLE [dbo].[UserInfo]  WITH CHECK ADD  CONSTRAINT [CK_User_rank] CHECK  (([rank]>=(0)))
GO

ALTER TABLE [dbo].[UserInfo] CHECK CONSTRAINT [CK_User_rank]
GO

ALTER TABLE [dbo].[UserInfo]  WITH CHECK ADD  CONSTRAINT [CK_User_sex] CHECK  (([sex]='男' OR [sex]='女'))
GO

ALTER TABLE [dbo].[UserInfo] CHECK CONSTRAINT [CK_User_sex]
GO


USE [onlineshop]
GO

/****** Object:  Table [dbo].[UserOrder]    Script Date: 04/28/2016 08:44:30 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[UserOrder](
	[o_id] [char](13) NOT NULL,
	[u_id] [nvarchar](20) NOT NULL,
	[o_time] [nvarchar](50) NOT NULL,
	[totalprice] [money] NOT NULL,
	[o_status] [char](1) NOT NULL,
	[freight] [money] NOT NULL,
	[paymentmode] [nvarchar](20) NOT NULL,
	[sendaddrId] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Order] PRIMARY KEY CLUSTERED 
(
	[o_id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO

ALTER TABLE [dbo].[UserOrder]  WITH CHECK ADD  CONSTRAINT [FK_Order_User] FOREIGN KEY([sendaddrId])
REFERENCES [dbo].[SendAddr] ([addrId])
GO

ALTER TABLE [dbo].[UserOrder] CHECK CONSTRAINT [FK_Order_User]
GO


