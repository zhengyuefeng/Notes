Linux 虚拟网桥的特点
- 可以设置 IP 地址
- 相当于拥有一个隐藏的虚拟网卡

Docker0 的地址划分
- IP `172.17.42.1` 子网掩码 `255.255.0.0`
- MAC : `02:42:ac:11:00:00` 到 `02:42:ac:11:ff:ff`
- 总共提供 `65534` 个地址