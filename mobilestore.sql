USE [master]
GO
/****** Object:  Database [mobilestore]    Script Date: 3/6/2022 8:46:35 PM ******/
CREATE DATABASE [mobilestore]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'mobillestore', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\mobillestore.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'mobillestore_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL14.SQLEXPRESS\MSSQL\DATA\mobillestore_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
GO
ALTER DATABASE [mobilestore] SET COMPATIBILITY_LEVEL = 140
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [mobilestore].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [mobilestore] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [mobilestore] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [mobilestore] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [mobilestore] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [mobilestore] SET ARITHABORT OFF 
GO
ALTER DATABASE [mobilestore] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [mobilestore] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [mobilestore] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [mobilestore] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [mobilestore] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [mobilestore] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [mobilestore] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [mobilestore] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [mobilestore] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [mobilestore] SET  DISABLE_BROKER 
GO
ALTER DATABASE [mobilestore] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [mobilestore] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [mobilestore] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [mobilestore] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [mobilestore] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [mobilestore] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [mobilestore] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [mobilestore] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [mobilestore] SET  MULTI_USER 
GO
ALTER DATABASE [mobilestore] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [mobilestore] SET DB_CHAINING OFF 
GO
ALTER DATABASE [mobilestore] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [mobilestore] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [mobilestore] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [mobilestore] SET QUERY_STORE = OFF
GO
USE [mobilestore]
GO
/****** Object:  Table [dbo].[account]    Script Date: 3/6/2022 8:46:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[account](
	[username] [varchar](25) NOT NULL,
	[password] [varchar](16) NOT NULL,
	[role] [varchar](10) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[username] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[order_details]    Script Date: 3/6/2022 8:46:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[order_details](
	[orderid] [int] NOT NULL,
	[product_code] [int] NOT NULL,
	[price] [float] NOT NULL,
	[quantity] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[orderid] ASC,
	[product_code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[orders]    Script Date: 3/6/2022 8:46:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[orders](
	[orderid] [int] IDENTITY(1,1) NOT NULL,
	[ordered_date] [date] NULL,
	[total] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[orderid] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[products]    Script Date: 3/6/2022 8:46:35 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[products](
	[code] [int] IDENTITY(1,1) NOT NULL,
	[condition] [varchar](20) NOT NULL,
	[description] [varchar](260) NOT NULL,
	[image] [varchar](1050) NULL,
	[manufacturer] [varchar](40) NOT NULL,
	[name] [varchar](40) NOT NULL,
	[stock] [int] NOT NULL,
	[unit_price] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[code] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[account] ([username], [password], [role]) VALUES (N'admin', N'123456', N'admin')
GO
INSERT [dbo].[order_details] ([orderid], [product_code], [price], [quantity]) VALUES (2, 7, 1798, 2)
GO
SET IDENTITY_INSERT [dbo].[orders] ON 

INSERT [dbo].[orders] ([orderid], [ordered_date], [total]) VALUES (1, NULL, 1798)
INSERT [dbo].[orders] ([orderid], [ordered_date], [total]) VALUES (2, NULL, 1798)
SET IDENTITY_INSERT [dbo].[orders] OFF
GO
SET IDENTITY_INSERT [dbo].[products] ON 

INSERT [dbo].[products] ([code], [condition], [description], [image], [manufacturer], [name], [stock], [unit_price]) VALUES (1, N'old', N'A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile broadband cellular network connection for voice, SMS, and internet data communication; most, if not all, smartphones also support Wi-Fi', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSLzOkzbOwf4Ci75j1WEQLSVV5Jz1ptXG33-g&usqp=CAU', N'apple', N'Iphone X', 245, 1099)
INSERT [dbo].[products] ([code], [condition], [description], [image], [manufacturer], [name], [stock], [unit_price]) VALUES (7, N'new', N'A smartphone is a handheld personal computer with a mobile operating system and an integrated mobile broadband cellular network connection for voice, SMS, and internet data communication; most, if not all, smartphones also support Wi-Fi', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQxHIWgOE2RC250DeltquW_eC5kWW4_TIMtKw&usqp=CAU', N'huawei', N'P20 Pro 128GB Dual SIM Twilight', 2, 899)
INSERT [dbo].[products] ([code], [condition], [description], [image], [manufacturer], [name], [stock], [unit_price]) VALUES (8, N'New', N'Apple newest iphone', N'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRbai30vQxlTh5_2jXW4gxYkvyrM3WUfsJMA4zNmtOHh0H3QaFDcK_4ZLG1US1sPdsXWUY&usqp=CAU', N'apple', N'Iphone 13 pro max', 350, 1499)
INSERT [dbo].[products] ([code], [condition], [description], [image], [manufacturer], [name], [stock], [unit_price]) VALUES (9, N'Refurbished', N'Iphone newest version of 8 plus', N'https://th.bing.com/th/id/R.bc74e701f5cdf13f3277dbe42dbc590b?rik=eBesJHRMivHNrA&pid=ImgRaw&r=0', N'apple', N'Iphone 11 pro max', 15, 3500)
SET IDENTITY_INSERT [dbo].[products] OFF
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD  CONSTRAINT [FKa5vweschq2jedqmgee03ifr12] FOREIGN KEY([product_code])
REFERENCES [dbo].[products] ([code])
GO
ALTER TABLE [dbo].[order_details] CHECK CONSTRAINT [FKa5vweschq2jedqmgee03ifr12]
GO
ALTER TABLE [dbo].[order_details]  WITH CHECK ADD  CONSTRAINT [FKh35b1ljeu4440iie9psw8a7yt] FOREIGN KEY([orderid])
REFERENCES [dbo].[orders] ([orderid])
GO
ALTER TABLE [dbo].[order_details] CHECK CONSTRAINT [FKh35b1ljeu4440iie9psw8a7yt]
GO
USE [master]
GO
ALTER DATABASE [mobilestore] SET  READ_WRITE 
GO
