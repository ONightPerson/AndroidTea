Loaded disassembler from /Library/Java/JavaVirtualMachines/jdk1.8.0_241.jdk/Contents/Home/jre/lib/server/hsdis-amd64.dylib
Decoding compiled method 0x0000000110bcc050:
Code:
[Disassembling for mach='i386:x86-64']
[Entry Point]
[Constants]
  # {method} {0x000000010db7b000} 'hashCode' '()I' in 'java/lang/String'
  #           [sp+0x40]  (sp of caller)
  0x0000000110bcc1c0: mov    0x8(%rsi),%r10d
  0x0000000110bcc1c4: shl    $0x3,%r10
  0x0000000110bcc1c8: cmp    %rax,%r10
  0x0000000110bcc1cb: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bcc1d1: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bcc1dc: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bcc1e0: mov    %eax,-0x14000(%rsp)
  0x0000000110bcc1e7: push   %rbp
  0x0000000110bcc1e8: sub    $0x30,%rsp
  0x0000000110bcc1ec: movabs $0x10dd43078,%rax  ;   {metadata(method data for {method} {0x000000010db7b000} 'hashCode' '()I' in 'java/lang/String')}
  0x0000000110bcc1f6: mov    0xdc(%rax),%edi
  0x0000000110bcc1fc: add    $0x8,%edi
  0x0000000110bcc1ff: mov    %edi,0xdc(%rax)
  0x0000000110bcc205: movabs $0x10db7b000,%rax  ;   {metadata({method} {0x000000010db7b000} 'hashCode' '()I' in 'java/lang/String')}
  0x0000000110bcc20f: and    $0x1ff8,%edi
  0x0000000110bcc215: cmp    $0x0,%edi
  0x0000000110bcc218: je     0x0000000110bcc351  ;*aload_0
                                                ; - java.lang.String::hashCode@0 (line 1466)

  0x0000000110bcc21e: mov    0x10(%rsi),%eax    ;*getfield hash
                                                ; - java.lang.String::hashCode@1 (line 1466)

  0x0000000110bcc221: cmp    $0x0,%eax
  0x0000000110bcc224: movabs $0x10dd43078,%rdi  ;   {metadata(method data for {method} {0x000000010db7b000} 'hashCode' '()I' in 'java/lang/String')}
  0x0000000110bcc22e: movabs $0x108,%rbx
  0x0000000110bcc238: jne    0x0000000110bcc248
  0x0000000110bcc23e: movabs $0x118,%rbx
  0x0000000110bcc248: mov    (%rdi,%rbx,1),%rdx
  0x0000000110bcc24c: lea    0x1(%rdx),%rdx
  0x0000000110bcc250: mov    %rdx,(%rdi,%rbx,1)
  0x0000000110bcc254: jne    0x0000000110bcc345  ;*ifne
                                                ; - java.lang.String::hashCode@6 (line 1467)

  0x0000000110bcc25a: mov    0xc(%rsi),%edi
  0x0000000110bcc25d: shl    $0x3,%rdi          ;*getfield value
                                                ; - java.lang.String::hashCode@10 (line 1467)

  0x0000000110bcc261: mov    0xc(%rdi),%ebx     ;*arraylength
                                                ; - java.lang.String::hashCode@13 (line 1467)
                                                ; implicit exception: dispatches to 0x0000000110bcc368
  0x0000000110bcc264: cmp    $0x0,%ebx
  0x0000000110bcc267: movabs $0x10dd43078,%rdx  ;   {metadata(method data for {method} {0x000000010db7b000} 'hashCode' '()I' in 'java/lang/String')}
  0x0000000110bcc271: movabs $0x128,%rcx
  0x0000000110bcc27b: jle    0x0000000110bcc28b
  0x0000000110bcc281: movabs $0x138,%rcx
  0x0000000110bcc28b: mov    (%rdx,%rcx,1),%r8
  0x0000000110bcc28f: lea    0x1(%r8),%r8
  0x0000000110bcc293: mov    %r8,(%rdx,%rcx,1)
  0x0000000110bcc297: jle    0x0000000110bcc345  ;*ifle
                                                ; - java.lang.String::hashCode@14 (line 1467)

  0x0000000110bcc29d: mov    $0x0,%edx
  0x0000000110bcc2a2: jmpq   0x0000000110bcc30a  ;*iload_3
                                                ; - java.lang.String::hashCode@24 (line 1470)

  0x0000000110bcc2a7: nop
  0x0000000110bcc2a8: movslq %edx,%rcx
  0x0000000110bcc2ab: movzwl 0x10(%rdi,%rcx,2),%ecx  ;*caload
                                                ; - java.lang.String::hashCode@39 (line 1471)

  0x0000000110bcc2b0: mov    %rax,%r8
  0x0000000110bcc2b3: shl    $0x5,%eax
  0x0000000110bcc2b6: sub    %r8d,%eax
  0x0000000110bcc2b9: add    %ecx,%eax
  0x0000000110bcc2bb: inc    %edx
  0x0000000110bcc2bd: movabs $0x10dd43078,%rcx  ;   {metadata(method data for {method} {0x000000010db7b000} 'hashCode' '()I' in 'java/lang/String')}
  0x0000000110bcc2c7: mov    0xe0(%rcx),%r8d
  0x0000000110bcc2ce: add    $0x8,%r8d
  0x0000000110bcc2d2: mov    %r8d,0xe0(%rcx)
  0x0000000110bcc2d9: movabs $0x10db7b000,%rcx  ;   {metadata({method} {0x000000010db7b000} 'hashCode' '()I' in 'java/lang/String')}
  0x0000000110bcc2e3: and    $0xfff8,%r8d
  0x0000000110bcc2ea: cmp    $0x0,%r8d
  0x0000000110bcc2ee: je     0x0000000110bcc36d  ; OopMap{rdi=Oop rsi=Oop off=308}
                                                ;*goto
                                                ; - java.lang.String::hashCode@45 (line 1470)

  0x0000000110bcc2f4: test   %eax,-0xf1d51fa(%rip)        # 0x00000001019f7100
                                                ;   {poll}
  0x0000000110bcc2fa: movabs $0x10dd43078,%rcx  ;   {metadata(method data for {method} {0x000000010db7b000} 'hashCode' '()I' in 'java/lang/String')}
  0x0000000110bcc304: incl   0x168(%rcx)        ;*goto
                                                ; - java.lang.String::hashCode@45 (line 1470)

  0x0000000110bcc30a: cmp    %ebx,%edx
  0x0000000110bcc30c: movabs $0x10dd43078,%rcx  ;   {metadata(method data for {method} {0x000000010db7b000} 'hashCode' '()I' in 'java/lang/String')}
  0x0000000110bcc316: movabs $0x148,%r8
  0x0000000110bcc320: jge    0x0000000110bcc330
  0x0000000110bcc326: movabs $0x158,%r8
  0x0000000110bcc330: mov    (%rcx,%r8,1),%r9
  0x0000000110bcc334: lea    0x1(%r9),%r9
  0x0000000110bcc338: mov    %r9,(%rcx,%r8,1)
  0x0000000110bcc33c: jl     0x0000000110bcc2a8  ;*if_icmpge
                                                ; - java.lang.String::hashCode@30 (line 1470)

  0x0000000110bcc342: mov    %eax,0x10(%rsi)    ;*putfield hash
                                                ; - java.lang.String::hashCode@50 (line 1473)

  0x0000000110bcc345: add    $0x30,%rsp
  0x0000000110bcc349: pop    %rbp
  0x0000000110bcc34a: test   %eax,-0xf1d5250(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bcc350: retq   
  0x0000000110bcc351: mov    %rax,0x8(%rsp)
  0x0000000110bcc356: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bcc35e: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop off=419}
                                                ;*synchronization entry
                                                ; - java.lang.String::hashCode@-1 (line 1466)
                                                ;   {runtime_call}
  0x0000000110bcc363: jmpq   0x0000000110bcc21e
  0x0000000110bcc368: callq  0x0000000110bc6240  ; OopMap{rsi=Oop rdi=Oop off=429}
                                                ;*arraylength
                                                ; - java.lang.String::hashCode@13 (line 1467)
                                                ;   {runtime_call}
  0x0000000110bcc36d: mov    %rcx,0x8(%rsp)
  0x0000000110bcc372: movq   $0x2d,(%rsp)
  0x0000000110bcc37a: callq  0x0000000110bca9e0  ; OopMap{rdi=Oop rsi=Oop off=447}
                                                ;*goto
                                                ; - java.lang.String::hashCode@45 (line 1470)
                                                ;   {runtime_call}
  0x0000000110bcc37f: jmpq   0x0000000110bcc2f4
  0x0000000110bcc384: nop
  0x0000000110bcc385: nop
  0x0000000110bcc386: mov    0x2a8(%r15),%rax
  0x0000000110bcc38d: movabs $0x0,%r10
  0x0000000110bcc397: mov    %r10,0x2a8(%r15)
  0x0000000110bcc39e: movabs $0x0,%r10
  0x0000000110bcc3a8: mov    %r10,0x2b0(%r15)
  0x0000000110bcc3af: add    $0x30,%rsp
  0x0000000110bcc3b3: pop    %rbp
  0x0000000110bcc3b4: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bcc3b9: hlt    
  0x0000000110bcc3ba: hlt    
  0x0000000110bcc3bb: hlt    
  0x0000000110bcc3bc: hlt    
  0x0000000110bcc3bd: hlt    
  0x0000000110bcc3be: hlt    
  0x0000000110bcc3bf: hlt    
[Exception Handler]
[Stub Code]
  0x0000000110bcc3c0: callq  0x0000000110bc80e0  ;   {no_reloc}
  0x0000000110bcc3c5: mov    %rsp,-0x28(%rsp)
  0x0000000110bcc3ca: sub    $0x80,%rsp
  0x0000000110bcc3d1: mov    %rax,0x78(%rsp)
  0x0000000110bcc3d6: mov    %rcx,0x70(%rsp)
  0x0000000110bcc3db: mov    %rdx,0x68(%rsp)
  0x0000000110bcc3e0: mov    %rbx,0x60(%rsp)
  0x0000000110bcc3e5: mov    %rbp,0x50(%rsp)
  0x0000000110bcc3ea: mov    %rsi,0x48(%rsp)
  0x0000000110bcc3ef: mov    %rdi,0x40(%rsp)
  0x0000000110bcc3f4: mov    %r8,0x38(%rsp)
  0x0000000110bcc3f9: mov    %r9,0x30(%rsp)
  0x0000000110bcc3fe: mov    %r10,0x28(%rsp)
  0x0000000110bcc403: mov    %r11,0x20(%rsp)
  0x0000000110bcc408: mov    %r12,0x18(%rsp)
  0x0000000110bcc40d: mov    %r13,0x10(%rsp)
  0x0000000110bcc412: mov    %r14,0x8(%rsp)
  0x0000000110bcc417: mov    %r15,(%rsp)
  0x0000000110bcc41b: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bcc425: movabs $0x110bcc3c5,%rsi  ;   {internal_word}
  0x0000000110bcc42f: mov    %rsp,%rdx
  0x0000000110bcc432: and    $0xfffffffffffffff0,%rsp
  0x0000000110bcc436: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bcc43b: hlt    
[Deopt Handler Code]
  0x0000000110bcc43c: movabs $0x110bcc43c,%r10  ;   {section_word}
  0x0000000110bcc446: push   %r10
  0x0000000110bcc448: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bcc44d: hlt    
  0x0000000110bcc44e: hlt    
  0x0000000110bcc44f: hlt    
Decoding compiled method 0x0000000110bcb4d0:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010db79c60} 'length' '()I' in 'java/lang/String'
  #           [sp+0x40]  (sp of caller)
  0x0000000110bcb640: mov    0x8(%rsi),%r10d
  0x0000000110bcb644: shl    $0x3,%r10
  0x0000000110bcb648: cmp    %rax,%r10
  0x0000000110bcb64b: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bcb651: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bcb65c: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bcb660: mov    %eax,-0x14000(%rsp)
  0x0000000110bcb667: push   %rbp
  0x0000000110bcb668: sub    $0x30,%rsp
  0x0000000110bcb66c: movabs $0x10dd60ec0,%rax  ;   {metadata(method data for {method} {0x000000010db79c60} 'length' '()I' in 'java/lang/String')}
  0x0000000110bcb676: mov    0xdc(%rax),%edi
  0x0000000110bcb67c: add    $0x8,%edi
  0x0000000110bcb67f: mov    %edi,0xdc(%rax)
  0x0000000110bcb685: movabs $0x10db79c60,%rax  ;   {metadata({method} {0x000000010db79c60} 'length' '()I' in 'java/lang/String')}
  0x0000000110bcb68f: and    $0x1ff8,%edi
  0x0000000110bcb695: cmp    $0x0,%edi
  0x0000000110bcb698: je     0x0000000110bcb6b4  ;*aload_0
                                                ; - java.lang.String::length@0 (line 623)

  0x0000000110bcb69e: mov    0xc(%rsi),%eax
  0x0000000110bcb6a1: shl    $0x3,%rax          ;*getfield value
                                                ; - java.lang.String::length@1 (line 623)

  0x0000000110bcb6a5: mov    0xc(%rax),%eax     ;*arraylength
                                                ; - java.lang.String::length@4 (line 623)
                                                ; implicit exception: dispatches to 0x0000000110bcb6c8
  0x0000000110bcb6a8: add    $0x30,%rsp
  0x0000000110bcb6ac: pop    %rbp
  0x0000000110bcb6ad: test   %eax,-0xf1d45b3(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bcb6b3: retq   
  0x0000000110bcb6b4: mov    %rax,0x8(%rsp)
  0x0000000110bcb6b9: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bcb6c1: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop off=134}
                                                ;*synchronization entry
                                                ; - java.lang.String::length@-1 (line 623)
                                                ;   {runtime_call}
  0x0000000110bcb6c6: jmp    0x0000000110bcb69e
  0x0000000110bcb6c8: callq  0x0000000110bc6240  ; OopMap{off=141}
                                                ;*arraylength
                                                ; - java.lang.String::length@4 (line 623)
                                                ;   {runtime_call}
  0x0000000110bcb6cd: nop
  0x0000000110bcb6ce: nop
  0x0000000110bcb6cf: mov    0x2a8(%r15),%rax
  0x0000000110bcb6d6: movabs $0x0,%r10
  0x0000000110bcb6e0: mov    %r10,0x2a8(%r15)
  0x0000000110bcb6e7: movabs $0x0,%r10
  0x0000000110bcb6f1: mov    %r10,0x2b0(%r15)
  0x0000000110bcb6f8: add    $0x30,%rsp
  0x0000000110bcb6fc: pop    %rbp
  0x0000000110bcb6fd: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bcb702: hlt    
  0x0000000110bcb703: hlt    
  0x0000000110bcb704: hlt    
  0x0000000110bcb705: hlt    
  0x0000000110bcb706: hlt    
  0x0000000110bcb707: hlt    
  0x0000000110bcb708: hlt    
  0x0000000110bcb709: hlt    
  0x0000000110bcb70a: hlt    
  0x0000000110bcb70b: hlt    
  0x0000000110bcb70c: hlt    
  0x0000000110bcb70d: hlt    
  0x0000000110bcb70e: hlt    
  0x0000000110bcb70f: hlt    
  0x0000000110bcb710: hlt    
  0x0000000110bcb711: hlt    
  0x0000000110bcb712: hlt    
  0x0000000110bcb713: hlt    
  0x0000000110bcb714: hlt    
  0x0000000110bcb715: hlt    
  0x0000000110bcb716: hlt    
  0x0000000110bcb717: hlt    
  0x0000000110bcb718: hlt    
  0x0000000110bcb719: hlt    
  0x0000000110bcb71a: hlt    
  0x0000000110bcb71b: hlt    
  0x0000000110bcb71c: hlt    
  0x0000000110bcb71d: hlt    
  0x0000000110bcb71e: hlt    
  0x0000000110bcb71f: hlt    
[Exception Handler]
[Stub Code]
  0x0000000110bcb720: callq  0x0000000110bc80e0  ;   {no_reloc}
  0x0000000110bcb725: mov    %rsp,-0x28(%rsp)
  0x0000000110bcb72a: sub    $0x80,%rsp
  0x0000000110bcb731: mov    %rax,0x78(%rsp)
  0x0000000110bcb736: mov    %rcx,0x70(%rsp)
  0x0000000110bcb73b: mov    %rdx,0x68(%rsp)
  0x0000000110bcb740: mov    %rbx,0x60(%rsp)
  0x0000000110bcb745: mov    %rbp,0x50(%rsp)
  0x0000000110bcb74a: mov    %rsi,0x48(%rsp)
  0x0000000110bcb74f: mov    %rdi,0x40(%rsp)
  0x0000000110bcb754: mov    %r8,0x38(%rsp)
  0x0000000110bcb759: mov    %r9,0x30(%rsp)
  0x0000000110bcb75e: mov    %r10,0x28(%rsp)
  0x0000000110bcb763: mov    %r11,0x20(%rsp)
  0x0000000110bcb768: mov    %r12,0x18(%rsp)
  0x0000000110bcb76d: mov    %r13,0x10(%rsp)
  0x0000000110bcb772: mov    %r14,0x8(%rsp)
  0x0000000110bcb777: mov    %r15,(%rsp)
  0x0000000110bcb77b: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bcb785: movabs $0x110bcb725,%rsi  ;   {internal_word}
  0x0000000110bcb78f: mov    %rsp,%rdx
  0x0000000110bcb792: and    $0xfffffffffffffff0,%rsp
  0x0000000110bcb796: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bcb79b: hlt    
[Deopt Handler Code]
  0x0000000110bcb79c: movabs $0x110bcb79c,%r10  ;   {section_word}
  0x0000000110bcb7a6: push   %r10
  0x0000000110bcb7a8: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bcb7ad: hlt    
  0x0000000110bcb7ae: hlt    
  0x0000000110bcb7af: hlt    
Decoding compiled method 0x0000000110bcde90:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010db79db0} 'charAt' '(I)C' in 'java/lang/String'
  # this:     rsi:rsi   = 'java/lang/String'
  # parm0:    rdx       = int
  #           [sp+0x40]  (sp of caller)
  0x0000000110bce000: mov    0x8(%rsi),%r10d
  0x0000000110bce004: shl    $0x3,%r10
  0x0000000110bce008: cmp    %rax,%r10
  0x0000000110bce00b: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bce011: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bce01c: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bce020: mov    %eax,-0x14000(%rsp)
  0x0000000110bce027: push   %rbp
  0x0000000110bce028: sub    $0x30,%rsp
  0x0000000110bce02c: mov    %rdx,%rdi
  0x0000000110bce02f: movabs $0x10dcfcb88,%rax  ;   {metadata(method data for {method} {0x000000010db79db0} 'charAt' '(I)C' in 'java/lang/String')}
  0x0000000110bce039: mov    0xdc(%rax),%edx
  0x0000000110bce03f: add    $0x8,%edx
  0x0000000110bce042: mov    %edx,0xdc(%rax)
  0x0000000110bce048: movabs $0x10db79db0,%rax  ;   {metadata({method} {0x000000010db79db0} 'charAt' '(I)C' in 'java/lang/String')}
  0x0000000110bce052: and    $0x1ff8,%edx
  0x0000000110bce058: cmp    $0x0,%edx
  0x0000000110bce05b: je     0x0000000110bce136  ;*iload_1
                                                ; - java.lang.String::charAt@0 (line 657)

  0x0000000110bce061: cmp    $0x0,%edi
  0x0000000110bce064: movabs $0x10dcfcb88,%rax  ;   {metadata(method data for {method} {0x000000010db79db0} 'charAt' '(I)C' in 'java/lang/String')}
  0x0000000110bce06e: movabs $0x108,%rdx
  0x0000000110bce078: jl     0x0000000110bce088
  0x0000000110bce07e: movabs $0x118,%rdx
  0x0000000110bce088: mov    (%rax,%rdx,1),%rbx
  0x0000000110bce08c: lea    0x1(%rbx),%rbx
  0x0000000110bce090: mov    %rbx,(%rax,%rdx,1)
  0x0000000110bce094: jl     0x0000000110bce0f6  ;*iflt
                                                ; - java.lang.String::charAt@1 (line 657)

  0x0000000110bce09a: mov    0xc(%rsi),%eax
  0x0000000110bce09d: shl    $0x3,%rax          ;*getfield value
                                                ; - java.lang.String::charAt@6 (line 657)

  0x0000000110bce0a1: mov    0xc(%rax),%edx     ;*arraylength
                                                ; - java.lang.String::charAt@9 (line 657)
                                                ; implicit exception: dispatches to 0x0000000110bce14d
  0x0000000110bce0a4: cmp    %edx,%edi
  0x0000000110bce0a6: movabs $0x10dcfcb88,%rdx  ;   {metadata(method data for {method} {0x000000010db79db0} 'charAt' '(I)C' in 'java/lang/String')}
  0x0000000110bce0b0: movabs $0x128,%rsi
  0x0000000110bce0ba: jl     0x0000000110bce0ca
  0x0000000110bce0c0: movabs $0x138,%rsi
  0x0000000110bce0ca: mov    (%rdx,%rsi,1),%rbx
  0x0000000110bce0ce: lea    0x1(%rbx),%rbx
  0x0000000110bce0d2: mov    %rbx,(%rdx,%rsi,1)
  0x0000000110bce0d6: jge    0x0000000110bce0f6  ;*if_icmplt
                                                ; - java.lang.String::charAt@10 (line 657)

  0x0000000110bce0dc: movslq %edi,%rdi
  0x0000000110bce0df: movzwl 0x10(%rax,%rdi,2),%eax  ;*caload
                                                ; - java.lang.String::charAt@27 (line 660)

  0x0000000110bce0e4: and    $0xffff,%eax
  0x0000000110bce0ea: add    $0x30,%rsp
  0x0000000110bce0ee: pop    %rbp
  0x0000000110bce0ef: test   %eax,-0xf1d6ff5(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bce0f5: retq                      ;*ireturn
                                                ; - java.lang.String::charAt@28 (line 660)

  0x0000000110bce0f6: xchg   %ax,%ax
  0x0000000110bce0f8: jmpq   0x0000000110bce161  ;   {no_reloc}
  0x0000000110bce0fd: add    %al,(%rax)
  0x0000000110bce0ff: add    %al,(%rax)
  0x0000000110bce101: add    %ch,%cl
  0x0000000110bce103: add    %al,%fs:(%rax)
  0x0000000110bce106: add    %cl,-0x75(%rax)    ;*new  ; - java.lang.String::charAt@13 (line 658)

  0x0000000110bce109: rorb   -0x42(%rax)        ;   {metadata(method data for {method} {0x000000010db79db0} 'charAt' '(I)C' in 'java/lang/String')}
  0x0000000110bce10c: mov    %cl,%bl
  0x0000000110bce10e: iret   
  0x0000000110bce10f: or     $0x1,%eax
  0x0000000110bce114: addq   $0x1,0x148(%rsi)
  0x0000000110bce11c: mov    %rdi,%rdx
  0x0000000110bce11f: mov    %rax,%rsi          ;*invokespecial <init>
                                                ; - java.lang.String::charAt@18 (line 658)

  0x0000000110bce122: mov    %rax,0x20(%rsp)
  0x0000000110bce127: callq  0x0000000110b110a0  ; OopMap{[32]=Oop off=300}
                                                ;*invokespecial <init>
                                                ; - java.lang.String::charAt@18 (line 658)
                                                ;   {optimized virtual_call}
  0x0000000110bce12c: mov    0x20(%rsp),%rax
  0x0000000110bce131: jmpq   0x0000000110bce1a0
  0x0000000110bce136: mov    %rax,0x8(%rsp)
  0x0000000110bce13b: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bce143: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop off=328}
                                                ;*synchronization entry
                                                ; - java.lang.String::charAt@-1 (line 657)
                                                ;   {runtime_call}
  0x0000000110bce148: jmpq   0x0000000110bce061
  0x0000000110bce14d: callq  0x0000000110bc6240  ; OopMap{rax=Oop off=338}
                                                ;*arraylength
                                                ; - java.lang.String::charAt@9 (line 657)
                                                ;   {runtime_call}
  0x0000000110bce152: movabs $0x0,%rdx          ;   {metadata(NULL)}
  0x0000000110bce15c: mov    $0xa050f00,%eax
  0x0000000110bce161: callq  0x0000000110bc98a0  ; OopMap{off=358}
                                                ;*new  ; - java.lang.String::charAt@13 (line 658)
                                                ;   {runtime_call}
  0x0000000110bce166: jmp    0x0000000110bce0f8
  0x0000000110bce168: nop
  0x0000000110bce169: nop
  0x0000000110bce16a: nop
  0x0000000110bce16b: mov    %rdx,%rdx
  0x0000000110bce16e: callq  0x0000000110bc66e0  ; OopMap{off=371}
                                                ;*new  ; - java.lang.String::charAt@13 (line 658)
                                                ;   {runtime_call}
  0x0000000110bce173: jmp    0x0000000110bce107
  0x0000000110bce175: nop
  0x0000000110bce176: nop
  0x0000000110bce177: mov    0x2a8(%r15),%rax
  0x0000000110bce17e: movabs $0x0,%r10
  0x0000000110bce188: mov    %r10,0x2a8(%r15)
  0x0000000110bce18f: movabs $0x0,%r10
  0x0000000110bce199: mov    %r10,0x2b0(%r15)
  0x0000000110bce1a0: add    $0x30,%rsp
  0x0000000110bce1a4: pop    %rbp
  0x0000000110bce1a5: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bce1aa: hlt    
  0x0000000110bce1ab: hlt    
  0x0000000110bce1ac: hlt    
  0x0000000110bce1ad: hlt    
  0x0000000110bce1ae: hlt    
  0x0000000110bce1af: hlt    
  0x0000000110bce1b0: hlt    
  0x0000000110bce1b1: hlt    
  0x0000000110bce1b2: hlt    
  0x0000000110bce1b3: hlt    
  0x0000000110bce1b4: hlt    
  0x0000000110bce1b5: hlt    
  0x0000000110bce1b6: hlt    
  0x0000000110bce1b7: hlt    
  0x0000000110bce1b8: hlt    
  0x0000000110bce1b9: hlt    
  0x0000000110bce1ba: hlt    
  0x0000000110bce1bb: hlt    
  0x0000000110bce1bc: hlt    
  0x0000000110bce1bd: hlt    
  0x0000000110bce1be: hlt    
  0x0000000110bce1bf: hlt    
[Stub Code]
  0x0000000110bce1c0: nop                       ;   {no_reloc}
  0x0000000110bce1c1: nop
  0x0000000110bce1c2: nop
  0x0000000110bce1c3: nop
  0x0000000110bce1c4: nop
  0x0000000110bce1c5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bce1cf: jmpq   0x0000000110bce1cf  ;   {runtime_call}
[Exception Handler]
  0x0000000110bce1d4: callq  0x0000000110bc80e0  ;   {runtime_call}
  0x0000000110bce1d9: mov    %rsp,-0x28(%rsp)
  0x0000000110bce1de: sub    $0x80,%rsp
  0x0000000110bce1e5: mov    %rax,0x78(%rsp)
  0x0000000110bce1ea: mov    %rcx,0x70(%rsp)
  0x0000000110bce1ef: mov    %rdx,0x68(%rsp)
  0x0000000110bce1f4: mov    %rbx,0x60(%rsp)
  0x0000000110bce1f9: mov    %rbp,0x50(%rsp)
  0x0000000110bce1fe: mov    %rsi,0x48(%rsp)
  0x0000000110bce203: mov    %rdi,0x40(%rsp)
  0x0000000110bce208: mov    %r8,0x38(%rsp)
  0x0000000110bce20d: mov    %r9,0x30(%rsp)
  0x0000000110bce212: mov    %r10,0x28(%rsp)
  0x0000000110bce217: mov    %r11,0x20(%rsp)
  0x0000000110bce21c: mov    %r12,0x18(%rsp)
  0x0000000110bce221: mov    %r13,0x10(%rsp)
  0x0000000110bce226: mov    %r14,0x8(%rsp)
  0x0000000110bce22b: mov    %r15,(%rsp)
  0x0000000110bce22f: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bce239: movabs $0x110bce1d9,%rsi  ;   {internal_word}
  0x0000000110bce243: mov    %rsp,%rdx
  0x0000000110bce246: and    $0xfffffffffffffff0,%rsp
  0x0000000110bce24a: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bce24f: hlt    
[Deopt Handler Code]
  0x0000000110bce250: movabs $0x110bce250,%r10  ;   {section_word}
  0x0000000110bce25a: push   %r10
  0x0000000110bce25c: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bce261: hlt    
  0x0000000110bce262: hlt    
  0x0000000110bce263: hlt    
  0x0000000110bce264: hlt    
  0x0000000110bce265: hlt    
  0x0000000110bce266: hlt    
  0x0000000110bce267: hlt    
Decoding compiled method 0x0000000110bcdb10:
Code:
[Entry Point]
  # {method} {0x000000010db8f868} 'arraycopy' '(Ljava/lang/Object;ILjava/lang/Object;II)V' in 'java/lang/System'
  # parm0:    rsi:rsi   = 'java/lang/Object'
  # parm1:    rdx       = int
  # parm2:    rcx:rcx   = 'java/lang/Object'
  # parm3:    r8        = int
  # parm4:    r9        = int
  #           [sp+0x60]  (sp of caller)
  0x0000000110bcdc80: mov    0x8(%rsi),%r10d
  0x0000000110bcdc84: shl    $0x3,%r10
  0x0000000110bcdc88: cmp    %r10,%rax
  0x0000000110bcdc8b: je     0x0000000110bcdc98
  0x0000000110bcdc91: jmpq   0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bcdc96: xchg   %ax,%ax
[Verified Entry Point]
  0x0000000110bcdc98: mov    %eax,-0x14000(%rsp)
  0x0000000110bcdc9f: push   %rbp
  0x0000000110bcdca0: mov    %rsp,%rbp
  0x0000000110bcdca3: sub    $0x50,%rsp
  0x0000000110bcdca7: mov    %r9,(%rsp)
  0x0000000110bcdcab: mov    %r8,%r9
  0x0000000110bcdcae: mov    %rcx,0x18(%rsp)
  0x0000000110bcdcb3: cmp    $0x0,%rcx
  0x0000000110bcdcb7: lea    0x18(%rsp),%r8
  0x0000000110bcdcbc: cmove  0x18(%rsp),%r8
  0x0000000110bcdcc2: mov    %rdx,%rcx
  0x0000000110bcdcc5: mov    %rsi,0x8(%rsp)
  0x0000000110bcdcca: cmp    $0x0,%rsi
  0x0000000110bcdcce: lea    0x8(%rsp),%rdx
  0x0000000110bcdcd3: cmove  0x8(%rsp),%rdx
  0x0000000110bcdcd9: movabs $0x76ab00c78,%r14  ;   {oop(a 'java/lang/Class' = 'java/lang/System')}
  0x0000000110bcdce3: mov    %r14,0x38(%rsp)
  0x0000000110bcdce8: lea    0x38(%rsp),%r14
  0x0000000110bcdced: mov    %r14,%rsi          ; OopMap{[24]=Oop [8]=Oop [56]=Oop off=112}
  0x0000000110bcdcf0: movabs $0x110bcdcf0,%r10  ;   {section_word}
  0x0000000110bcdcfa: mov    %r10,0x1e0(%r15)
  0x0000000110bcdd01: mov    %rsp,0x1d8(%r15)
  0x0000000110bcdd08: cmpb   $0x0,-0xd0d580d(%rip)        # 0x0000000103af8502
                                                ;   {external_word}
  0x0000000110bcdd0f: je     0x0000000110bcdd53
  0x0000000110bcdd15: push   %rsi
  0x0000000110bcdd16: push   %rdx
  0x0000000110bcdd17: push   %rcx
  0x0000000110bcdd18: push   %r8
  0x0000000110bcdd1a: push   %r9
  0x0000000110bcdd1c: movabs $0x10db8f868,%rsi  ;   {metadata({method} {0x000000010db8f868} 'arraycopy' '(Ljava/lang/Object;ILjava/lang/Object;II)V' in 'java/lang/System')}
  0x0000000110bcdd26: mov    %r15,%rdi
  0x0000000110bcdd29: test   $0xf,%esp
  0x0000000110bcdd2f: je     0x0000000110bcdd47
  0x0000000110bcdd35: sub    $0x8,%rsp
  0x0000000110bcdd39: callq  0x00000001036eea30  ;   {runtime_call}
  0x0000000110bcdd3e: add    $0x8,%rsp
  0x0000000110bcdd42: jmpq   0x0000000110bcdd4c
  0x0000000110bcdd47: callq  0x00000001036eea30  ;   {runtime_call}
  0x0000000110bcdd4c: pop    %r9
  0x0000000110bcdd4e: pop    %r8
  0x0000000110bcdd50: pop    %rcx
  0x0000000110bcdd51: pop    %rdx
  0x0000000110bcdd52: pop    %rsi
  0x0000000110bcdd53: lea    0x1f8(%r15),%rdi
  0x0000000110bcdd5a: movl   $0x4,0x270(%r15)
  0x0000000110bcdd65: callq  0x0000000103547c8c  ;   {runtime_call}
  0x0000000110bcdd6a: vzeroupper 
  0x0000000110bcdd6d: movl   $0x5,0x270(%r15)
  0x0000000110bcdd78: lock addl $0x0,(%rsp)
  0x0000000110bcdd7d: cmpl   $0x0,-0xd0caed7(%rip)        # 0x0000000103b02eb0
                                                ;   {external_word}
  0x0000000110bcdd87: jne    0x0000000110bcdd9b
  0x0000000110bcdd8d: cmpl   $0x0,0x30(%r15)
  0x0000000110bcdd95: je     0x0000000110bcddb4
  0x0000000110bcdd9b: mov    %r15,%rdi
  0x0000000110bcdd9e: mov    %rsp,%r12
  0x0000000110bcdda1: sub    $0x0,%rsp
  0x0000000110bcdda5: and    $0xfffffffffffffff0,%rsp
  0x0000000110bcdda9: callq  0x0000000103775e1e  ;   {runtime_call}
  0x0000000110bcddae: mov    %r12,%rsp
  0x0000000110bcddb1: xor    %r12,%r12
  0x0000000110bcddb4: movl   $0x8,0x270(%r15)
  0x0000000110bcddbf: cmpl   $0x1,0x29c(%r15)
  0x0000000110bcddca: je     0x0000000110bcde52
  0x0000000110bcddd0: cmpb   $0x0,-0xd0d58d5(%rip)        # 0x0000000103af8502
                                                ;   {external_word}
  0x0000000110bcddd7: je     0x0000000110bcde0d
  0x0000000110bcdddd: movabs $0x10db8f868,%rsi  ;   {metadata({method} {0x000000010db8f868} 'arraycopy' '(Ljava/lang/Object;ILjava/lang/Object;II)V' in 'java/lang/System')}
  0x0000000110bcdde7: mov    %r15,%rdi
  0x0000000110bcddea: test   $0xf,%esp
  0x0000000110bcddf0: je     0x0000000110bcde08
  0x0000000110bcddf6: sub    $0x8,%rsp
  0x0000000110bcddfa: callq  0x00000001036ee9a2  ;   {runtime_call}
  0x0000000110bcddff: add    $0x8,%rsp
  0x0000000110bcde03: jmpq   0x0000000110bcde0d
  0x0000000110bcde08: callq  0x00000001036ee9a2  ;   {runtime_call}
  0x0000000110bcde0d: movabs $0x0,%r10
  0x0000000110bcde17: mov    %r10,0x1d8(%r15)
  0x0000000110bcde1e: movabs $0x0,%r10
  0x0000000110bcde28: mov    %r10,0x1e0(%r15)
  0x0000000110bcde2f: mov    0x38(%r15),%rcx
  0x0000000110bcde33: movl   $0x0,0x100(%rcx)
  0x0000000110bcde3d: leaveq 
  0x0000000110bcde3e: cmpq   $0x0,0x8(%r15)
  0x0000000110bcde46: jne    0x0000000110bcde4d
  0x0000000110bcde4c: retq   
  0x0000000110bcde4d: jmpq   Stub::forward exception  ;   {runtime_call}
  0x0000000110bcde52: mov    %rsp,%r12
  0x0000000110bcde55: sub    $0x0,%rsp
  0x0000000110bcde59: and    $0xfffffffffffffff0,%rsp
  0x0000000110bcde5d: callq  0x00000001036ec6e8  ;   {runtime_call}
  0x0000000110bcde62: mov    %r12,%rsp
  0x0000000110bcde65: xor    %r12,%r12
  0x0000000110bcde68: jmpq   0x0000000110bcddd0
  0x0000000110bcde6d: hlt    
  0x0000000110bcde6e: hlt    
  0x0000000110bcde6f: hlt    
Decoding compiled method 0x0000000110bcd390:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String'
  # this:     rsi:rsi   = 'java/lang/String'
  # parm0:    rdx       = int
  # parm1:    rcx       = int
  #           [sp+0x40]  (sp of caller)
  0x0000000110bcd520: mov    0x8(%rsi),%r10d
  0x0000000110bcd524: shl    $0x3,%r10
  0x0000000110bcd528: cmp    %rax,%r10
  0x0000000110bcd52b: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bcd531: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bcd53c: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bcd540: mov    %eax,-0x14000(%rsp)
  0x0000000110bcd547: push   %rbp
  0x0000000110bcd548: sub    $0x30,%rsp
  0x0000000110bcd54c: movabs $0x10dd67960,%rax  ;   {metadata(method data for {method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd556: mov    0xdc(%rax),%edi
  0x0000000110bcd55c: add    $0x8,%edi
  0x0000000110bcd55f: mov    %edi,0xdc(%rax)
  0x0000000110bcd565: movabs $0x10db7b180,%rax  ;   {metadata({method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd56f: and    $0x1ff8,%edi
  0x0000000110bcd575: cmp    $0x0,%edi
  0x0000000110bcd578: je     0x0000000110bcd781  ;*aload_0
                                                ; - java.lang.String::indexOf@0 (line 1546)

  0x0000000110bcd57e: mov    0xc(%rsi),%eax
  0x0000000110bcd581: shl    $0x3,%rax          ;*getfield value
                                                ; - java.lang.String::indexOf@1 (line 1546)

  0x0000000110bcd585: mov    0xc(%rax),%edi     ;*arraylength
                                                ; - java.lang.String::indexOf@4 (line 1546)
                                                ; implicit exception: dispatches to 0x0000000110bcd798
  0x0000000110bcd588: cmp    $0x0,%ecx
  0x0000000110bcd58b: movabs $0x10dd67960,%rbx  ;   {metadata(method data for {method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd595: movabs $0x108,%r8
  0x0000000110bcd59f: jge    0x0000000110bcd5af
  0x0000000110bcd5a5: movabs $0x118,%r8
  0x0000000110bcd5af: mov    (%rbx,%r8,1),%r9
  0x0000000110bcd5b3: lea    0x1(%r9),%r9
  0x0000000110bcd5b7: mov    %r9,(%rbx,%r8,1)
  0x0000000110bcd5bb: jge    0x0000000110bcd5db  ;*ifge
                                                ; - java.lang.String::indexOf@7 (line 1547)

  0x0000000110bcd5c1: movabs $0x10dd67960,%rcx  ;   {metadata(method data for {method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd5cb: incl   0x128(%rcx)
  0x0000000110bcd5d1: mov    $0x0,%ecx
  0x0000000110bcd5d6: jmpq   0x0000000110bcd613  ;*goto
                                                ; - java.lang.String::indexOf@12 (line 1548)

  0x0000000110bcd5db: cmp    %edi,%ecx
  0x0000000110bcd5dd: movabs $0x10dd67960,%rbx  ;   {metadata(method data for {method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd5e7: movabs $0x140,%r8
  0x0000000110bcd5f1: jl     0x0000000110bcd601
  0x0000000110bcd5f7: movabs $0x150,%r8
  0x0000000110bcd601: mov    (%rbx,%r8,1),%r9
  0x0000000110bcd605: lea    0x1(%r9),%r9
  0x0000000110bcd609: mov    %r9,(%rbx,%r8,1)
  0x0000000110bcd60d: jge    0x0000000110bcd770  ;*if_icmplt
                                                ; - java.lang.String::indexOf@17 (line 1549)

  0x0000000110bcd613: cmp    $0x10000,%edx
  0x0000000110bcd619: movabs $0x10dd67960,%rbx  ;   {metadata(method data for {method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd623: movabs $0x160,%r8
  0x0000000110bcd62d: jge    0x0000000110bcd63d
  0x0000000110bcd633: movabs $0x170,%r8
  0x0000000110bcd63d: mov    (%rbx,%r8,1),%r9
  0x0000000110bcd641: lea    0x1(%r9),%r9
  0x0000000110bcd645: mov    %r9,(%rbx,%r8,1)
  0x0000000110bcd649: jge    0x0000000110bcd748
  0x0000000110bcd64f: jmpq   0x0000000110bcd6eb  ;*if_icmpge
                                                ; - java.lang.String::indexOf@25 (line 1554)

  0x0000000110bcd654: nopl   0x0(%rax)
  0x0000000110bcd658: movslq %ecx,%rsi
  0x0000000110bcd65b: cmp    0xc(%rax),%ecx
  0x0000000110bcd65e: jae    0x0000000110bcd79d
  0x0000000110bcd664: movzwl 0x10(%rax,%rsi,2),%esi  ;*caload
                                                ; - java.lang.String::indexOf@47 (line 1559)

  0x0000000110bcd669: cmp    %edx,%esi
  0x0000000110bcd66b: movabs $0x10dd67960,%rsi  ;   {metadata(method data for {method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd675: movabs $0x1a0,%rbx
  0x0000000110bcd67f: jne    0x0000000110bcd68f
  0x0000000110bcd685: movabs $0x1b0,%rbx
  0x0000000110bcd68f: mov    (%rsi,%rbx,1),%r8
  0x0000000110bcd693: lea    0x1(%r8),%r8
  0x0000000110bcd697: mov    %r8,(%rsi,%rbx,1)
  0x0000000110bcd69b: je     0x0000000110bcd728  ;*if_icmpne
                                                ; - java.lang.String::indexOf@49 (line 1559)

  0x0000000110bcd6a1: inc    %ecx
  0x0000000110bcd6a3: movabs $0x10dd67960,%rsi  ;   {metadata(method data for {method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd6ad: mov    0xe0(%rsi),%ebx
  0x0000000110bcd6b3: add    $0x8,%ebx
  0x0000000110bcd6b6: mov    %ebx,0xe0(%rsi)
  0x0000000110bcd6bc: movabs $0x10db7b180,%rsi  ;   {metadata({method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd6c6: and    $0xfff8,%ebx
  0x0000000110bcd6cc: cmp    $0x0,%ebx
  0x0000000110bcd6cf: je     0x0000000110bcd7a6  ; OopMap{rax=Oop off=437}
                                                ;*goto
                                                ; - java.lang.String::indexOf@58 (line 1558)

  0x0000000110bcd6d5: test   %eax,-0xf1d65db(%rip)        # 0x00000001019f7100
                                                ;   {poll}
  0x0000000110bcd6db: movabs $0x10dd67960,%rsi  ;   {metadata(method data for {method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd6e5: incl   0x1c0(%rsi)        ;*goto
                                                ; - java.lang.String::indexOf@58 (line 1558)

  0x0000000110bcd6eb: cmp    %edi,%ecx
  0x0000000110bcd6ed: movabs $0x10dd67960,%rsi  ;   {metadata(method data for {method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd6f7: movabs $0x180,%rbx
  0x0000000110bcd701: jge    0x0000000110bcd711
  0x0000000110bcd707: movabs $0x190,%rbx
  0x0000000110bcd711: mov    (%rsi,%rbx,1),%r8
  0x0000000110bcd715: lea    0x1(%r8),%r8
  0x0000000110bcd719: mov    %r8,(%rsi,%rbx,1)
  0x0000000110bcd71d: jge    0x0000000110bcd737
  0x0000000110bcd723: jmpq   0x0000000110bcd658  ;*if_icmpge
                                                ; - java.lang.String::indexOf@40 (line 1558)

  0x0000000110bcd728: mov    %rcx,%rax
  0x0000000110bcd72b: add    $0x30,%rsp
  0x0000000110bcd72f: pop    %rbp
  0x0000000110bcd730: test   %eax,-0xf1d6636(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bcd736: retq                      ;*ireturn
                                                ; - java.lang.String::indexOf@54 (line 1560)

  0x0000000110bcd737: mov    $0xffffffff,%eax
  0x0000000110bcd73c: add    $0x30,%rsp
  0x0000000110bcd740: pop    %rbp
  0x0000000110bcd741: test   %eax,-0xf1d6647(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bcd747: retq                      ;*ireturn
                                                ; - java.lang.String::indexOf@62 (line 1563)

  0x0000000110bcd748: mov    %rsi,%rdi
  0x0000000110bcd74b: movabs $0x10dd67960,%rbx  ;   {metadata(method data for {method} {0x000000010db7b180} 'indexOf' '(II)I' in 'java/lang/String')}
  0x0000000110bcd755: addq   $0x1,0x1d8(%rbx)
  0x0000000110bcd75d: nop
  0x0000000110bcd75e: nop
  0x0000000110bcd75f: callq  0x0000000110b110a0  ; OopMap{off=580}
                                                ;*invokespecial indexOfSupplementary
                                                ; - java.lang.String::indexOf@66 (line 1565)
                                                ;   {optimized virtual_call}
  0x0000000110bcd764: add    $0x30,%rsp
  0x0000000110bcd768: pop    %rbp
  0x0000000110bcd769: test   %eax,-0xf1d666f(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bcd76f: retq                      ;*ireturn
                                                ; - java.lang.String::indexOf@69 (line 1565)

  0x0000000110bcd770: mov    $0xffffffff,%eax
  0x0000000110bcd775: add    $0x30,%rsp
  0x0000000110bcd779: pop    %rbp
  0x0000000110bcd77a: test   %eax,-0xf1d6680(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bcd780: retq   
  0x0000000110bcd781: mov    %rax,0x8(%rsp)
  0x0000000110bcd786: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bcd78e: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop off=627}
                                                ;*synchronization entry
                                                ; - java.lang.String::indexOf@-1 (line 1546)
                                                ;   {runtime_call}
  0x0000000110bcd793: jmpq   0x0000000110bcd57e
  0x0000000110bcd798: callq  0x0000000110bc6240  ; OopMap{rsi=Oop rax=Oop off=637}
                                                ;*arraylength
                                                ; - java.lang.String::indexOf@4 (line 1546)
                                                ;   {runtime_call}
  0x0000000110bcd79d: mov    %rcx,(%rsp)
  0x0000000110bcd7a1: callq  0x0000000110b38800  ; OopMap{rax=Oop off=646}
                                                ;*caload
                                                ; - java.lang.String::indexOf@47 (line 1559)
                                                ;   {runtime_call}
  0x0000000110bcd7a6: mov    %rsi,0x8(%rsp)
  0x0000000110bcd7ab: movq   $0x3a,(%rsp)
  0x0000000110bcd7b3: callq  0x0000000110bca9e0  ; OopMap{rax=Oop off=664}
                                                ;*goto
                                                ; - java.lang.String::indexOf@58 (line 1558)
                                                ;   {runtime_call}
  0x0000000110bcd7b8: jmpq   0x0000000110bcd6d5
  0x0000000110bcd7bd: nop
  0x0000000110bcd7be: nop
  0x0000000110bcd7bf: mov    0x2a8(%r15),%rax
  0x0000000110bcd7c6: movabs $0x0,%r10
  0x0000000110bcd7d0: mov    %r10,0x2a8(%r15)
  0x0000000110bcd7d7: movabs $0x0,%r10
  0x0000000110bcd7e1: mov    %r10,0x2b0(%r15)
  0x0000000110bcd7e8: add    $0x30,%rsp
  0x0000000110bcd7ec: pop    %rbp
  0x0000000110bcd7ed: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bcd7f2: hlt    
  0x0000000110bcd7f3: hlt    
  0x0000000110bcd7f4: hlt    
  0x0000000110bcd7f5: hlt    
  0x0000000110bcd7f6: hlt    
  0x0000000110bcd7f7: hlt    
  0x0000000110bcd7f8: hlt    
  0x0000000110bcd7f9: hlt    
  0x0000000110bcd7fa: hlt    
  0x0000000110bcd7fb: hlt    
  0x0000000110bcd7fc: hlt    
  0x0000000110bcd7fd: hlt    
  0x0000000110bcd7fe: hlt    
  0x0000000110bcd7ff: hlt    
[Stub Code]
  0x0000000110bcd800: nop                       ;   {no_reloc}
  0x0000000110bcd801: nop
  0x0000000110bcd802: nop
  0x0000000110bcd803: nop
  0x0000000110bcd804: nop
  0x0000000110bcd805: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bcd80f: jmpq   0x0000000110bcd80f  ;   {runtime_call}
[Exception Handler]
  0x0000000110bcd814: callq  0x0000000110bc80e0  ;   {runtime_call}
  0x0000000110bcd819: mov    %rsp,-0x28(%rsp)
  0x0000000110bcd81e: sub    $0x80,%rsp
  0x0000000110bcd825: mov    %rax,0x78(%rsp)
  0x0000000110bcd82a: mov    %rcx,0x70(%rsp)
  0x0000000110bcd82f: mov    %rdx,0x68(%rsp)
  0x0000000110bcd834: mov    %rbx,0x60(%rsp)
  0x0000000110bcd839: mov    %rbp,0x50(%rsp)
  0x0000000110bcd83e: mov    %rsi,0x48(%rsp)
  0x0000000110bcd843: mov    %rdi,0x40(%rsp)
  0x0000000110bcd848: mov    %r8,0x38(%rsp)
  0x0000000110bcd84d: mov    %r9,0x30(%rsp)
  0x0000000110bcd852: mov    %r10,0x28(%rsp)
  0x0000000110bcd857: mov    %r11,0x20(%rsp)
  0x0000000110bcd85c: mov    %r12,0x18(%rsp)
  0x0000000110bcd861: mov    %r13,0x10(%rsp)
  0x0000000110bcd866: mov    %r14,0x8(%rsp)
  0x0000000110bcd86b: mov    %r15,(%rsp)
  0x0000000110bcd86f: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bcd879: movabs $0x110bcd819,%rsi  ;   {internal_word}
  0x0000000110bcd883: mov    %rsp,%rdx
  0x0000000110bcd886: and    $0xfffffffffffffff0,%rsp
  0x0000000110bcd88a: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bcd88f: hlt    
[Deopt Handler Code]
  0x0000000110bcd890: movabs $0x110bcd890,%r10  ;   {section_word}
  0x0000000110bcd89a: push   %r10
  0x0000000110bcd89c: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bcd8a1: hlt    
  0x0000000110bcd8a2: hlt    
  0x0000000110bcd8a3: hlt    
  0x0000000110bcd8a4: hlt    
  0x0000000110bcd8a5: hlt    
  0x0000000110bcd8a6: hlt    
  0x0000000110bcd8a7: hlt    
Decoding compiled method 0x0000000110bcf910:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String'
  # this:     rsi:rsi   = 'java/lang/String'
  # parm0:    rdx:rdx   = 'java/lang/Object'
  #           [sp+0x40]  (sp of caller)
  0x0000000110bcfaa0: mov    0x8(%rsi),%r10d
  0x0000000110bcfaa4: shl    $0x3,%r10
  0x0000000110bcfaa8: cmp    %rax,%r10
  0x0000000110bcfaab: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bcfab1: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bcfabc: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bcfac0: mov    %eax,-0x14000(%rsp)
  0x0000000110bcfac7: push   %rbp
  0x0000000110bcfac8: sub    $0x30,%rsp
  0x0000000110bcfacc: movabs $0x10dd67f50,%rax  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfad6: mov    0xdc(%rax),%edi
  0x0000000110bcfadc: add    $0x8,%edi
  0x0000000110bcfadf: mov    %edi,0xdc(%rax)
  0x0000000110bcfae5: movabs $0x10db7a618,%rax  ;   {metadata({method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfaef: and    $0x1ff8,%edi
  0x0000000110bcfaf5: cmp    $0x0,%edi
  0x0000000110bcfaf8: je     0x0000000110bcfec6  ;*aload_0
                                                ; - java.lang.String::equals@0 (line 977)

  0x0000000110bcfafe: cmp    %rdx,%rsi
  0x0000000110bcfb01: movabs $0x10dd67f50,%rax  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfb0b: movabs $0x108,%rdi
  0x0000000110bcfb15: jne    0x0000000110bcfb25
  0x0000000110bcfb1b: movabs $0x118,%rdi
  0x0000000110bcfb25: mov    (%rax,%rdi,1),%rbx
  0x0000000110bcfb29: lea    0x1(%rbx),%rbx
  0x0000000110bcfb2d: mov    %rbx,(%rax,%rdi,1)
  0x0000000110bcfb31: je     0x0000000110bcfeb5  ;*if_acmpne
                                                ; - java.lang.String::equals@2 (line 977)

  0x0000000110bcfb37: cmp    $0x0,%rdx
  0x0000000110bcfb3b: jne    0x0000000110bcfb56
  0x0000000110bcfb3d: movabs $0x10dd67f50,%rbx  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfb47: orl    $0x100,0x120(%rbx)
  0x0000000110bcfb51: jmpq   0x0000000110bcfc16
  0x0000000110bcfb56: movabs $0x7c00016d0,%rcx  ;   {metadata('java/lang/String')}
  0x0000000110bcfb60: mov    0x8(%rdx),%edi
  0x0000000110bcfb63: shl    $0x3,%rdi
  0x0000000110bcfb67: cmp    %rdi,%rcx
  0x0000000110bcfb6a: jne    0x0000000110bcfbfa
  0x0000000110bcfb70: movabs $0x10dd67f50,%rbx  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfb7a: mov    0x8(%rdx),%ecx
  0x0000000110bcfb7d: shl    $0x3,%rcx
  0x0000000110bcfb81: cmp    0x130(%rbx),%rcx
  0x0000000110bcfb88: jne    0x0000000110bcfb97
  0x0000000110bcfb8a: addq   $0x1,0x138(%rbx)
  0x0000000110bcfb92: jmpq   0x0000000110bcfc1b
  0x0000000110bcfb97: cmp    0x140(%rbx),%rcx
  0x0000000110bcfb9e: jne    0x0000000110bcfbad
  0x0000000110bcfba0: addq   $0x1,0x148(%rbx)
  0x0000000110bcfba8: jmpq   0x0000000110bcfc1b
  0x0000000110bcfbad: cmpq   $0x0,0x130(%rbx)
  0x0000000110bcfbb8: jne    0x0000000110bcfbd1
  0x0000000110bcfbba: mov    %rcx,0x130(%rbx)
  0x0000000110bcfbc1: movq   $0x1,0x138(%rbx)
  0x0000000110bcfbcc: jmpq   0x0000000110bcfc1b
  0x0000000110bcfbd1: cmpq   $0x0,0x140(%rbx)
  0x0000000110bcfbdc: jne    0x0000000110bcfbf5
  0x0000000110bcfbde: mov    %rcx,0x140(%rbx)
  0x0000000110bcfbe5: movq   $0x1,0x148(%rbx)
  0x0000000110bcfbf0: jmpq   0x0000000110bcfc1b
  0x0000000110bcfbf5: jmpq   0x0000000110bcfc1b
  0x0000000110bcfbfa: movabs $0x10dd67f50,%rbx  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfc04: subq   $0x1,0x128(%rbx)
  0x0000000110bcfc0c: jmpq   0x0000000110bcfc16
  0x0000000110bcfc11: jmpq   0x0000000110bcfc1b
  0x0000000110bcfc16: xor    %rax,%rax
  0x0000000110bcfc19: jmp    0x0000000110bcfc25
  0x0000000110bcfc1b: movabs $0x1,%rax          ;*instanceof
                                                ; - java.lang.String::equals@8 (line 980)

  0x0000000110bcfc25: cmp    $0x0,%eax
  0x0000000110bcfc28: movabs $0x10dd67f50,%rax  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfc32: movabs $0x158,%rdi
  0x0000000110bcfc3c: je     0x0000000110bcfc4c
  0x0000000110bcfc42: movabs $0x168,%rdi
  0x0000000110bcfc4c: mov    (%rax,%rdi,1),%rbx
  0x0000000110bcfc50: lea    0x1(%rbx),%rbx
  0x0000000110bcfc54: mov    %rbx,(%rax,%rdi,1)
  0x0000000110bcfc58: je     0x0000000110bcfea4  ;*ifeq
                                                ; - java.lang.String::equals@11 (line 980)

  0x0000000110bcfc5e: cmp    $0x0,%rdx
  0x0000000110bcfc62: jne    0x0000000110bcfc7d
  0x0000000110bcfc64: movabs $0x10dd67f50,%rbx  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfc6e: orl    $0x100,0x170(%rbx)
  0x0000000110bcfc78: jmpq   0x0000000110bcfd3d
  0x0000000110bcfc7d: movabs $0x7c00016d0,%rax  ;   {metadata('java/lang/String')}
  0x0000000110bcfc87: mov    0x8(%rdx),%edi
  0x0000000110bcfc8a: shl    $0x3,%rdi
  0x0000000110bcfc8e: cmp    %rdi,%rax
  0x0000000110bcfc91: jne    0x0000000110bcfd21
  0x0000000110bcfc97: movabs $0x10dd67f50,%rbx  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfca1: mov    0x8(%rdx),%eax
  0x0000000110bcfca4: shl    $0x3,%rax
  0x0000000110bcfca8: cmp    0x180(%rbx),%rax
  0x0000000110bcfcaf: jne    0x0000000110bcfcbe
  0x0000000110bcfcb1: addq   $0x1,0x188(%rbx)
  0x0000000110bcfcb9: jmpq   0x0000000110bcfd3d
  0x0000000110bcfcbe: cmp    0x190(%rbx),%rax
  0x0000000110bcfcc5: jne    0x0000000110bcfcd4
  0x0000000110bcfcc7: addq   $0x1,0x198(%rbx)
  0x0000000110bcfccf: jmpq   0x0000000110bcfd3d
  0x0000000110bcfcd4: cmpq   $0x0,0x180(%rbx)
  0x0000000110bcfcdf: jne    0x0000000110bcfcf8
  0x0000000110bcfce1: mov    %rax,0x180(%rbx)
  0x0000000110bcfce8: movq   $0x1,0x188(%rbx)
  0x0000000110bcfcf3: jmpq   0x0000000110bcfd3d
  0x0000000110bcfcf8: cmpq   $0x0,0x190(%rbx)
  0x0000000110bcfd03: jne    0x0000000110bcfd1c
  0x0000000110bcfd05: mov    %rax,0x190(%rbx)
  0x0000000110bcfd0c: movq   $0x1,0x198(%rbx)
  0x0000000110bcfd17: jmpq   0x0000000110bcfd3d
  0x0000000110bcfd1c: jmpq   0x0000000110bcfd3d
  0x0000000110bcfd21: movabs $0x10dd67f50,%rbx  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfd2b: subq   $0x1,0x178(%rbx)
  0x0000000110bcfd33: jmpq   0x0000000110bcfedd
  0x0000000110bcfd38: jmpq   0x0000000110bcfd3d
  0x0000000110bcfd3d: mov    %rdx,%rax          ;*checkcast
                                                ; - java.lang.String::equals@15 (line 981)

  0x0000000110bcfd40: mov    0xc(%rsi),%esi
  0x0000000110bcfd43: shl    $0x3,%rsi          ;*getfield value
                                                ; - java.lang.String::equals@20 (line 982)

  0x0000000110bcfd47: mov    0xc(%rsi),%edi     ;*arraylength
                                                ; - java.lang.String::equals@23 (line 982)
                                                ; implicit exception: dispatches to 0x0000000110bcfee6
  0x0000000110bcfd4a: mov    0xc(%rax),%eax     ; implicit exception: dispatches to 0x0000000110bcfeeb
  0x0000000110bcfd4d: shl    $0x3,%rax          ;*getfield value
                                                ; - java.lang.String::equals@27 (line 983)

  0x0000000110bcfd51: mov    0xc(%rax),%ebx     ;*arraylength
                                                ; - java.lang.String::equals@30 (line 983)
                                                ; implicit exception: dispatches to 0x0000000110bcfef0
  0x0000000110bcfd54: cmp    %ebx,%edi
  0x0000000110bcfd56: movabs $0x10dd67f50,%rbx  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfd60: movabs $0x1a8,%rdx
  0x0000000110bcfd6a: jne    0x0000000110bcfd7a
  0x0000000110bcfd70: movabs $0x1b8,%rdx
  0x0000000110bcfd7a: mov    (%rbx,%rdx,1),%rcx
  0x0000000110bcfd7e: lea    0x1(%rcx),%rcx
  0x0000000110bcfd82: mov    %rcx,(%rbx,%rdx,1)
  0x0000000110bcfd86: jne    0x0000000110bcfea4  ;*if_icmpne
                                                ; - java.lang.String::equals@31 (line 983)

  0x0000000110bcfd8c: mov    $0x0,%ebx
  0x0000000110bcfd91: jmpq   0x0000000110bcfe3f  ;*iload_3
                                                ; - java.lang.String::equals@49 (line 987)

  0x0000000110bcfd96: xchg   %ax,%ax
  0x0000000110bcfd98: movslq %ebx,%rdi
  0x0000000110bcfd9b: cmp    0xc(%rsi),%ebx
  0x0000000110bcfd9e: jae    0x0000000110bcfef5
  0x0000000110bcfda4: movzwl 0x10(%rsi,%rdi,2),%edi  ;*caload
                                                ; - java.lang.String::equals@60 (line 988)

  0x0000000110bcfda9: movslq %ebx,%rcx
  0x0000000110bcfdac: cmp    0xc(%rax),%ebx
  0x0000000110bcfdaf: jae    0x0000000110bcfefe
  0x0000000110bcfdb5: movzwl 0x10(%rax,%rcx,2),%ecx  ;*caload
                                                ; - java.lang.String::equals@65 (line 988)

  0x0000000110bcfdba: cmp    %ecx,%edi
  0x0000000110bcfdbc: movabs $0x10dd67f50,%rdi  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfdc6: movabs $0x1e8,%rcx
  0x0000000110bcfdd0: je     0x0000000110bcfde0
  0x0000000110bcfdd6: movabs $0x1f8,%rcx
  0x0000000110bcfde0: mov    (%rdi,%rcx,1),%r8
  0x0000000110bcfde4: lea    0x1(%r8),%r8
  0x0000000110bcfde8: mov    %r8,(%rdi,%rcx,1)
  0x0000000110bcfdec: jne    0x0000000110bcfe82  ;*if_icmpeq
                                                ; - java.lang.String::equals@66 (line 988)

  0x0000000110bcfdf2: inc    %ebx
  0x0000000110bcfdf4: movabs $0x10dd67f50,%rdi  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfdfe: mov    0xe0(%rdi),%ecx
  0x0000000110bcfe04: add    $0x8,%ecx
  0x0000000110bcfe07: mov    %ecx,0xe0(%rdi)
  0x0000000110bcfe0d: movabs $0x10db7a618,%rdi  ;   {metadata({method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfe17: and    $0xfff8,%ecx
  0x0000000110bcfe1d: cmp    $0x0,%ecx
  0x0000000110bcfe20: je     0x0000000110bcff07  ; OopMap{rax=Oop rsi=Oop off=902}
                                                ;*goto
                                                ; - java.lang.String::equals@74 (line 990)

  0x0000000110bcfe26: test   %eax,-0xf1d8d2c(%rip)        # 0x00000001019f7100
                                                ;   {poll}
  0x0000000110bcfe2c: movabs $0x10dd67f50,%rdi  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfe36: incl   0x208(%rdi)
  0x0000000110bcfe3c: mov    %rdx,%rdi          ;*goto
                                                ; - java.lang.String::equals@74 (line 990)

  0x0000000110bcfe3f: mov    %rdi,%rdx
  0x0000000110bcfe42: dec    %edx
  0x0000000110bcfe44: cmp    $0x0,%edi
  0x0000000110bcfe47: movabs $0x10dd67f50,%rdi  ;   {metadata(method data for {method} {0x000000010db7a618} 'equals' '(Ljava/lang/Object;)Z' in 'java/lang/String')}
  0x0000000110bcfe51: movabs $0x1c8,%rcx
  0x0000000110bcfe5b: je     0x0000000110bcfe6b
  0x0000000110bcfe61: movabs $0x1d8,%rcx
  0x0000000110bcfe6b: mov    (%rdi,%rcx,1),%r8
  0x0000000110bcfe6f: lea    0x1(%r8),%r8
  0x0000000110bcfe73: mov    %r8,(%rdi,%rcx,1)
  0x0000000110bcfe77: je     0x0000000110bcfe93
  0x0000000110bcfe7d: jmpq   0x0000000110bcfd98  ;*ifeq
                                                ; - java.lang.String::equals@53 (line 987)

  0x0000000110bcfe82: mov    $0x0,%eax
  0x0000000110bcfe87: add    $0x30,%rsp
  0x0000000110bcfe8b: pop    %rbp
  0x0000000110bcfe8c: test   %eax,-0xf1d8d92(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bcfe92: retq                      ;*ireturn
                                                ; - java.lang.String::equals@70 (line 989)

  0x0000000110bcfe93: mov    $0x1,%eax
  0x0000000110bcfe98: add    $0x30,%rsp
  0x0000000110bcfe9c: pop    %rbp
  0x0000000110bcfe9d: test   %eax,-0xf1d8da3(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bcfea3: retq                      ;*ireturn
                                                ; - java.lang.String::equals@78 (line 992)

  0x0000000110bcfea4: mov    $0x0,%eax
  0x0000000110bcfea9: add    $0x30,%rsp
  0x0000000110bcfead: pop    %rbp
  0x0000000110bcfeae: test   %eax,-0xf1d8db4(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bcfeb4: retq                      ;*ireturn
                                                ; - java.lang.String::equals@80 (line 995)

  0x0000000110bcfeb5: mov    $0x1,%eax
  0x0000000110bcfeba: add    $0x30,%rsp
  0x0000000110bcfebe: pop    %rbp
  0x0000000110bcfebf: test   %eax,-0xf1d8dc5(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bcfec5: retq   
  0x0000000110bcfec6: mov    %rax,0x8(%rsp)
  0x0000000110bcfecb: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bcfed3: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop rdx=Oop off=1080}
                                                ;*synchronization entry
                                                ; - java.lang.String::equals@-1 (line 977)
                                                ;   {runtime_call}
  0x0000000110bcfed8: jmpq   0x0000000110bcfafe
  0x0000000110bcfedd: mov    %rdx,(%rsp)
  0x0000000110bcfee1: callq  0x0000000110bc8440  ; OopMap{rsi=Oop off=1094}
                                                ;*checkcast
                                                ; - java.lang.String::equals@15 (line 981)
                                                ;   {runtime_call}
  0x0000000110bcfee6: callq  0x0000000110bc6240  ; OopMap{rax=Oop rsi=Oop off=1099}
                                                ;*arraylength
                                                ; - java.lang.String::equals@23 (line 982)
                                                ;   {runtime_call}
  0x0000000110bcfeeb: callq  0x0000000110bc6240  ; OopMap{rsi=Oop off=1104}
                                                ;*getfield value
                                                ; - java.lang.String::equals@27 (line 983)
                                                ;   {runtime_call}
  0x0000000110bcfef0: callq  0x0000000110bc6240  ; OopMap{rsi=Oop rax=Oop off=1109}
                                                ;*arraylength
                                                ; - java.lang.String::equals@30 (line 983)
                                                ;   {runtime_call}
  0x0000000110bcfef5: mov    %rbx,(%rsp)
  0x0000000110bcfef9: callq  0x0000000110b38800  ; OopMap{rax=Oop rsi=Oop off=1118}
                                                ;*caload
                                                ; - java.lang.String::equals@60 (line 988)
                                                ;   {runtime_call}
  0x0000000110bcfefe: mov    %rbx,(%rsp)
  0x0000000110bcff02: callq  0x0000000110b38800  ; OopMap{rax=Oop rsi=Oop off=1127}
                                                ;*caload
                                                ; - java.lang.String::equals@65 (line 988)
                                                ;   {runtime_call}
  0x0000000110bcff07: mov    %rdi,0x8(%rsp)
  0x0000000110bcff0c: movq   $0x4a,(%rsp)
  0x0000000110bcff14: callq  0x0000000110bca9e0  ; OopMap{rax=Oop rsi=Oop off=1145}
                                                ;*goto
                                                ; - java.lang.String::equals@74 (line 990)
                                                ;   {runtime_call}
  0x0000000110bcff19: jmpq   0x0000000110bcfe26
  0x0000000110bcff1e: nop
  0x0000000110bcff1f: nop
  0x0000000110bcff20: mov    0x2a8(%r15),%rax
  0x0000000110bcff27: movabs $0x0,%r10
  0x0000000110bcff31: mov    %r10,0x2a8(%r15)
  0x0000000110bcff38: movabs $0x0,%r10
  0x0000000110bcff42: mov    %r10,0x2b0(%r15)
  0x0000000110bcff49: add    $0x30,%rsp
  0x0000000110bcff4d: pop    %rbp
  0x0000000110bcff4e: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bcff53: hlt    
  0x0000000110bcff54: hlt    
  0x0000000110bcff55: hlt    
  0x0000000110bcff56: hlt    
  0x0000000110bcff57: hlt    
  0x0000000110bcff58: hlt    
  0x0000000110bcff59: hlt    
  0x0000000110bcff5a: hlt    
  0x0000000110bcff5b: hlt    
  0x0000000110bcff5c: hlt    
  0x0000000110bcff5d: hlt    
  0x0000000110bcff5e: hlt    
  0x0000000110bcff5f: hlt    
[Exception Handler]
[Stub Code]
  0x0000000110bcff60: callq  0x0000000110bc80e0  ;   {no_reloc}
  0x0000000110bcff65: mov    %rsp,-0x28(%rsp)
  0x0000000110bcff6a: sub    $0x80,%rsp
  0x0000000110bcff71: mov    %rax,0x78(%rsp)
  0x0000000110bcff76: mov    %rcx,0x70(%rsp)
  0x0000000110bcff7b: mov    %rdx,0x68(%rsp)
  0x0000000110bcff80: mov    %rbx,0x60(%rsp)
  0x0000000110bcff85: mov    %rbp,0x50(%rsp)
  0x0000000110bcff8a: mov    %rsi,0x48(%rsp)
  0x0000000110bcff8f: mov    %rdi,0x40(%rsp)
  0x0000000110bcff94: mov    %r8,0x38(%rsp)
  0x0000000110bcff99: mov    %r9,0x30(%rsp)
  0x0000000110bcff9e: mov    %r10,0x28(%rsp)
  0x0000000110bcffa3: mov    %r11,0x20(%rsp)
  0x0000000110bcffa8: mov    %r12,0x18(%rsp)
  0x0000000110bcffad: mov    %r13,0x10(%rsp)
  0x0000000110bcffb2: mov    %r14,0x8(%rsp)
  0x0000000110bcffb7: mov    %r15,(%rsp)
  0x0000000110bcffbb: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bcffc5: movabs $0x110bcff65,%rsi  ;   {internal_word}
  0x0000000110bcffcf: mov    %rsp,%rdx
  0x0000000110bcffd2: and    $0xfffffffffffffff0,%rsp
  0x0000000110bcffd6: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bcffdb: hlt    
[Deopt Handler Code]
  0x0000000110bcffdc: movabs $0x110bcffdc,%r10  ;   {section_word}
  0x0000000110bcffe6: push   %r10
  0x0000000110bcffe8: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bcffed: hlt    
  0x0000000110bcffee: hlt    
  0x0000000110bcffef: hlt    
Decoding compiled method 0x0000000110bcf090:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010dbeb610} 'ensureCapacityInternal' '(I)V' in 'java/lang/AbstractStringBuilder'
  # this:     rsi:rsi   = 'java/lang/AbstractStringBuilder'
  # parm0:    rdx       = int
  #           [sp+0xb0]  (sp of caller)
  0x0000000110bcf220: mov    0x8(%rsi),%r10d
  0x0000000110bcf224: shl    $0x3,%r10
  0x0000000110bcf228: cmp    %rax,%r10
  0x0000000110bcf22b: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bcf231: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bcf23c: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bcf240: mov    %eax,-0x14000(%rsp)
  0x0000000110bcf247: push   %rbp
  0x0000000110bcf248: sub    $0xa0,%rsp
  0x0000000110bcf24f: movabs $0x10dd6bec8,%rdi  ;   {metadata(method data for {method} {0x000000010dbeb610} 'ensureCapacityInternal' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bcf259: mov    0xdc(%rdi),%ebx
  0x0000000110bcf25f: add    $0x8,%ebx
  0x0000000110bcf262: mov    %ebx,0xdc(%rdi)
  0x0000000110bcf268: movabs $0x10dbeb610,%rdi  ;   {metadata({method} {0x000000010dbeb610} 'ensureCapacityInternal' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bcf272: and    $0x1ff8,%ebx
  0x0000000110bcf278: cmp    $0x0,%ebx
  0x0000000110bcf27b: je     0x0000000110bcf52f  ;*iload_1
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@0 (line 123)

  0x0000000110bcf281: mov    0x10(%rsi),%edi
  0x0000000110bcf284: shl    $0x3,%rdi          ;*getfield value
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@2 (line 123)

  0x0000000110bcf288: mov    0xc(%rdi),%ebx     ;*arraylength
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@5 (line 123)
                                                ; implicit exception: dispatches to 0x0000000110bcf546
  0x0000000110bcf28b: mov    %rdx,%rax
  0x0000000110bcf28e: sub    %ebx,%eax
  0x0000000110bcf290: cmp    $0x0,%eax
  0x0000000110bcf293: movabs $0x10dd6bec8,%rax  ;   {metadata(method data for {method} {0x000000010dbeb610} 'ensureCapacityInternal' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bcf29d: movabs $0x108,%rcx
  0x0000000110bcf2a7: jle    0x0000000110bcf2b7
  0x0000000110bcf2ad: movabs $0x118,%rcx
  0x0000000110bcf2b7: mov    (%rax,%rcx,1),%r8
  0x0000000110bcf2bb: lea    0x1(%r8),%r8
  0x0000000110bcf2bf: mov    %r8,(%rax,%rcx,1)
  0x0000000110bcf2c3: jle    0x0000000110bcf520  ;*ifle
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@7 (line 123)

  0x0000000110bcf2c9: mov    %ebx,0x78(%rsp)
  0x0000000110bcf2cd: mov    %rdi,0x80(%rsp)
  0x0000000110bcf2d5: mov    %rsi,%rax
  0x0000000110bcf2d8: movabs $0x10dd6bec8,%rcx  ;   {metadata(method data for {method} {0x000000010dbeb610} 'ensureCapacityInternal' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bcf2e2: addq   $0x1,0x128(%rcx)
  0x0000000110bcf2ea: mov    %rsi,%rax
  0x0000000110bcf2ed: mov    %rax,%rsi          ;*invokespecial newCapacity
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@17 (line 125)

  0x0000000110bcf2f0: mov    %rax,0x88(%rsp)
  0x0000000110bcf2f8: nop
  0x0000000110bcf2f9: nop
  0x0000000110bcf2fa: nop
  0x0000000110bcf2fb: nop
  0x0000000110bcf2fc: nop
  0x0000000110bcf2fd: nop
  0x0000000110bcf2fe: nop
  0x0000000110bcf2ff: callq  0x0000000110b110a0  ; OopMap{[128]=Oop [136]=Oop off=228}
                                                ;*invokespecial newCapacity
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@17 (line 125)
                                                ;   {optimized virtual_call}
  0x0000000110bcf304: mov    %rax,%r8           ;*invokespecial newCapacity
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@17 (line 125)

  0x0000000110bcf307: movabs $0x10dd6bec8,%rbx  ;   {metadata(method data for {method} {0x000000010dbeb610} 'ensureCapacityInternal' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bcf311: addq   $0x1,0x138(%rbx)
  0x0000000110bcf319: movabs $0x10dd6c208,%rbx  ;   {metadata(method data for {method} {0x000000010dc914b8} 'copyOf' '([CI)[C' in 'java/util/Arrays')}
  0x0000000110bcf323: mov    0xdc(%rbx),%edx
  0x0000000110bcf329: add    $0x8,%edx
  0x0000000110bcf32c: mov    %edx,0xdc(%rbx)
  0x0000000110bcf332: movabs $0x10dc914b8,%rbx  ;   {metadata({method} {0x000000010dc914b8} 'copyOf' '([CI)[C' in 'java/util/Arrays')}
  0x0000000110bcf33c: and    $0x7ffff8,%edx
  0x0000000110bcf342: cmp    $0x0,%edx
  0x0000000110bcf345: je     0x0000000110bcf54b
  0x0000000110bcf34b: mov    %r8,%rbx
  0x0000000110bcf34e: movabs $0x7c0000208,%rdx  ;   {metadata({type array char})}
  0x0000000110bcf358: movslq %ebx,%rbx
  0x0000000110bcf35b: mov    %rbx,%rdi
  0x0000000110bcf35e: cmp    $0xffffff,%rbx
  0x0000000110bcf365: ja     0x0000000110bcf562
  0x0000000110bcf36b: movabs $0x17,%rsi
  0x0000000110bcf375: lea    (%rsi,%rbx,2),%rsi
  0x0000000110bcf379: and    $0xfffffffffffffff8,%rsi
  0x0000000110bcf37d: mov    0x60(%r15),%rax
  0x0000000110bcf381: lea    (%rax,%rsi,1),%rsi
  0x0000000110bcf385: cmp    0x70(%r15),%rsi
  0x0000000110bcf389: ja     0x0000000110bcf562
  0x0000000110bcf38f: mov    %rsi,0x60(%r15)
  0x0000000110bcf393: sub    %rax,%rsi
  0x0000000110bcf396: movq   $0x1,(%rax)
  0x0000000110bcf39d: mov    %rdx,%rcx
  0x0000000110bcf3a0: shr    $0x3,%rcx
  0x0000000110bcf3a4: mov    %ecx,0x8(%rax)
  0x0000000110bcf3a7: mov    %ebx,0xc(%rax)
  0x0000000110bcf3aa: sub    $0x10,%rsi
  0x0000000110bcf3ae: je     0x0000000110bcf3c5
  0x0000000110bcf3b4: xor    %rbx,%rbx
  0x0000000110bcf3b7: shr    $0x3,%rsi
  0x0000000110bcf3bb: mov    %rbx,0x8(%rax,%rsi,8)
  0x0000000110bcf3c0: dec    %rsi
  0x0000000110bcf3c3: jne    0x0000000110bcf3bb  ;*newarray
                                                ; - java.util.Arrays::copyOf@1 (line 3332)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)

  0x0000000110bcf3c5: movabs $0x10dd6c208,%rsi  ;   {metadata(method data for {method} {0x000000010dc914b8} 'copyOf' '([CI)[C' in 'java/util/Arrays')}
  0x0000000110bcf3cf: addq   $0x1,0x108(%rsi)
  0x0000000110bcf3d7: movabs $0x10dd43210,%rsi  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bcf3e1: mov    0xdc(%rsi),%edx
  0x0000000110bcf3e7: add    $0x8,%edx
  0x0000000110bcf3ea: mov    %edx,0xdc(%rsi)
  0x0000000110bcf3f0: movabs $0x10dc6cd70,%rsi  ;   {metadata({method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bcf3fa: and    $0x7ffff8,%edx
  0x0000000110bcf400: cmp    $0x0,%edx
  0x0000000110bcf403: je     0x0000000110bcf56c
  0x0000000110bcf409: mov    0x78(%rsp),%ebx
  0x0000000110bcf40d: cmp    %r8d,%ebx
  0x0000000110bcf410: movabs $0x10dd43210,%rsi  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bcf41a: movabs $0x108,%rdx
  0x0000000110bcf424: jg     0x0000000110bcf434
  0x0000000110bcf42a: movabs $0x118,%rdx
  0x0000000110bcf434: mov    (%rsi,%rdx,1),%rcx
  0x0000000110bcf438: lea    0x1(%rcx),%rcx
  0x0000000110bcf43c: mov    %rcx,(%rsi,%rdx,1)
  0x0000000110bcf440: jg     0x0000000110bcf45b  ;*if_icmpgt
                                                ; - java.lang.Math::min@2 (line 1336)
                                                ; - java.util.Arrays::copyOf@11 (line 3334)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)

  0x0000000110bcf446: movabs $0x10dd43210,%rsi  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bcf450: incl   0x128(%rsi)
  0x0000000110bcf456: jmpq   0x0000000110bcf45e  ;*goto
                                                ; - java.lang.Math::min@6 (line 1336)
                                                ; - java.util.Arrays::copyOf@11 (line 3334)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)

  0x0000000110bcf45b: mov    %r8,%rbx           ;*ireturn
                                                ; - java.lang.Math::min@10 (line 1336)
                                                ; - java.util.Arrays::copyOf@11 (line 3334)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)

  0x0000000110bcf45e: mov    0x80(%rsp),%rdi
  0x0000000110bcf466: movabs $0x10dd6c208,%rsi  ;   {metadata(method data for {method} {0x000000010dc914b8} 'copyOf' '([CI)[C' in 'java/util/Arrays')}
  0x0000000110bcf470: addq   $0x1,0x118(%rsi)
  0x0000000110bcf478: mov    %rdi,%rsi
  0x0000000110bcf47b: mov    $0x0,%edx
  0x0000000110bcf480: mov    %rax,%rcx
  0x0000000110bcf483: mov    $0x0,%r8d
  0x0000000110bcf489: mov    %rbx,%r9
  0x0000000110bcf48c: mov    %rax,0x90(%rsp)
  0x0000000110bcf494: lea    (%rdx,%r9,1),%rdi
  0x0000000110bcf498: cmp    0xc(%rsi),%edi
  0x0000000110bcf49b: ja     0x0000000110bcf583
  0x0000000110bcf4a1: lea    (%r8,%r9,1),%rdi
  0x0000000110bcf4a5: cmp    0xc(%rcx),%edi
  0x0000000110bcf4a8: ja     0x0000000110bcf583
  0x0000000110bcf4ae: test   %r9d,%r9d
  0x0000000110bcf4b1: jl     0x0000000110bcf583
  0x0000000110bcf4b7: je     0x0000000110bcf4f3
  0x0000000110bcf4bd: movslq %edx,%rdx
  0x0000000110bcf4c0: movslq %r8d,%r8
  0x0000000110bcf4c3: lea    0x10(%rsi,%rdx,2),%rdi
  0x0000000110bcf4c8: lea    0x10(%rcx,%r8,2),%rsi
  0x0000000110bcf4cd: mov    %r9,%rdx
  0x0000000110bcf4d0: test   $0xf,%esp
  0x0000000110bcf4d6: je     0x0000000110bcf4ee
  0x0000000110bcf4dc: sub    $0x8,%rsp
  0x0000000110bcf4e0: callq  Stub::jshort_disjoint_arraycopy
                                                ;   {runtime_call}
  0x0000000110bcf4e5: add    $0x8,%rsp
  0x0000000110bcf4e9: jmpq   0x0000000110bcf4f3
  0x0000000110bcf4ee: callq  Stub::jshort_disjoint_arraycopy
                                                ;*invokestatic arraycopy
                                                ; - java.util.Arrays::copyOf@14 (line 3333)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ;   {runtime_call}
  0x0000000110bcf4f3: mov    0x90(%rsp),%rax
  0x0000000110bcf4fb: mov    0x88(%rsp),%rsi
  0x0000000110bcf503: mov    %rax,%r10
  0x0000000110bcf506: shr    $0x3,%r10
  0x0000000110bcf50a: mov    %r10d,0x10(%rsi)
  0x0000000110bcf50e: shr    $0x9,%rsi
  0x0000000110bcf512: movabs $0x100fcf000,%rdi
  0x0000000110bcf51c: movb   $0x0,(%rsi,%rdi,1)  ;*putfield value
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@23 (line 124)

  0x0000000110bcf520: add    $0xa0,%rsp
  0x0000000110bcf527: pop    %rbp
  0x0000000110bcf528: test   %eax,-0xf1d842e(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bcf52e: retq   
  0x0000000110bcf52f: mov    %rdi,0x8(%rsp)
  0x0000000110bcf534: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bcf53c: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop off=801}
                                                ;*synchronization entry
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@-1 (line 123)
                                                ;   {runtime_call}
  0x0000000110bcf541: jmpq   0x0000000110bcf281
  0x0000000110bcf546: callq  0x0000000110bc6240  ; OopMap{rsi=Oop rdi=Oop off=811}
                                                ;*arraylength
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@5 (line 123)
                                                ;   {runtime_call}
  0x0000000110bcf54b: mov    %rbx,0x8(%rsp)
  0x0000000110bcf550: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bcf558: callq  0x0000000110bca9e0  ; OopMap{[128]=Oop [136]=Oop off=829}
                                                ;*synchronization entry
                                                ; - java.util.Arrays::copyOf@-1 (line 3332)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ;   {runtime_call}
  0x0000000110bcf55d: jmpq   0x0000000110bcf34b
  0x0000000110bcf562: callq  0x0000000110bc72a0  ; OopMap{[128]=Oop [136]=Oop off=839}
                                                ;*newarray
                                                ; - java.util.Arrays::copyOf@1 (line 3332)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ;   {runtime_call}
  0x0000000110bcf567: jmpq   0x0000000110bcf3c5
  0x0000000110bcf56c: mov    %rsi,0x8(%rsp)
  0x0000000110bcf571: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bcf579: callq  0x0000000110bca9e0  ; OopMap{[128]=Oop [136]=Oop rax=Oop off=862}
                                                ;*synchronization entry
                                                ; - java.lang.Math::min@-1 (line 1336)
                                                ; - java.util.Arrays::copyOf@11 (line 3334)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ;   {runtime_call}
  0x0000000110bcf57e: jmpq   0x0000000110bcf409
  0x0000000110bcf583: nop
  0x0000000110bcf584: nop
  0x0000000110bcf585: nop
  0x0000000110bcf586: nop
  0x0000000110bcf587: callq  0x0000000110b11520  ; OopMap{[136]=Oop [144]=Oop off=876}
                                                ;*invokestatic arraycopy
                                                ; - java.util.Arrays::copyOf@14 (line 3333)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ;   {static_call}
  0x0000000110bcf58c: jmpq   0x0000000110bcf4f3
  0x0000000110bcf591: nop
  0x0000000110bcf592: nop
  0x0000000110bcf593: mov    0x2a8(%r15),%rax
  0x0000000110bcf59a: movabs $0x0,%r10
  0x0000000110bcf5a4: mov    %r10,0x2a8(%r15)
  0x0000000110bcf5ab: movabs $0x0,%r10
  0x0000000110bcf5b5: mov    %r10,0x2b0(%r15)
  0x0000000110bcf5bc: add    $0xa0,%rsp
  0x0000000110bcf5c3: pop    %rbp
  0x0000000110bcf5c4: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bcf5c9: hlt    
  0x0000000110bcf5ca: hlt    
  0x0000000110bcf5cb: hlt    
  0x0000000110bcf5cc: hlt    
  0x0000000110bcf5cd: hlt    
  0x0000000110bcf5ce: hlt    
  0x0000000110bcf5cf: hlt    
  0x0000000110bcf5d0: hlt    
  0x0000000110bcf5d1: hlt    
  0x0000000110bcf5d2: hlt    
  0x0000000110bcf5d3: hlt    
  0x0000000110bcf5d4: hlt    
  0x0000000110bcf5d5: hlt    
  0x0000000110bcf5d6: hlt    
  0x0000000110bcf5d7: hlt    
  0x0000000110bcf5d8: hlt    
  0x0000000110bcf5d9: hlt    
  0x0000000110bcf5da: hlt    
  0x0000000110bcf5db: hlt    
  0x0000000110bcf5dc: hlt    
  0x0000000110bcf5dd: hlt    
  0x0000000110bcf5de: hlt    
  0x0000000110bcf5df: hlt    
[Stub Code]
  0x0000000110bcf5e0: nop                       ;   {no_reloc}
  0x0000000110bcf5e1: nop
  0x0000000110bcf5e2: nop
  0x0000000110bcf5e3: nop
  0x0000000110bcf5e4: nop
  0x0000000110bcf5e5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bcf5ef: jmpq   0x0000000110bcf5ef  ;   {runtime_call}
  0x0000000110bcf5f4: nop
  0x0000000110bcf5f5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bcf5ff: jmpq   0x0000000110bcf5ff  ;   {runtime_call}
[Exception Handler]
  0x0000000110bcf604: callq  0x0000000110bc80e0  ;   {runtime_call}
  0x0000000110bcf609: mov    %rsp,-0x28(%rsp)
  0x0000000110bcf60e: sub    $0x80,%rsp
  0x0000000110bcf615: mov    %rax,0x78(%rsp)
  0x0000000110bcf61a: mov    %rcx,0x70(%rsp)
  0x0000000110bcf61f: mov    %rdx,0x68(%rsp)
  0x0000000110bcf624: mov    %rbx,0x60(%rsp)
  0x0000000110bcf629: mov    %rbp,0x50(%rsp)
  0x0000000110bcf62e: mov    %rsi,0x48(%rsp)
  0x0000000110bcf633: mov    %rdi,0x40(%rsp)
  0x0000000110bcf638: mov    %r8,0x38(%rsp)
  0x0000000110bcf63d: mov    %r9,0x30(%rsp)
  0x0000000110bcf642: mov    %r10,0x28(%rsp)
  0x0000000110bcf647: mov    %r11,0x20(%rsp)
  0x0000000110bcf64c: mov    %r12,0x18(%rsp)
  0x0000000110bcf651: mov    %r13,0x10(%rsp)
  0x0000000110bcf656: mov    %r14,0x8(%rsp)
  0x0000000110bcf65b: mov    %r15,(%rsp)
  0x0000000110bcf65f: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bcf669: movabs $0x110bcf609,%rsi  ;   {internal_word}
  0x0000000110bcf673: mov    %rsp,%rdx
  0x0000000110bcf676: and    $0xfffffffffffffff0,%rsp
  0x0000000110bcf67a: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bcf67f: hlt    
[Deopt Handler Code]
  0x0000000110bcf680: movabs $0x110bcf680,%r10  ;   {section_word}
  0x0000000110bcf68a: push   %r10
  0x0000000110bcf68c: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bcf691: hlt    
  0x0000000110bcf692: hlt    
  0x0000000110bcf693: hlt    
  0x0000000110bcf694: hlt    
  0x0000000110bcf695: hlt    
  0x0000000110bcf696: hlt    
  0x0000000110bcf697: hlt    
Decoding compiled method 0x0000000110bdac10:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010db76480} '<init>' '()V' in 'java/lang/Object'
  #           [sp+0x40]  (sp of caller)
  0x0000000110bdad80: mov    0x8(%rsi),%r10d
  0x0000000110bdad84: shl    $0x3,%r10
  0x0000000110bdad88: cmp    %rax,%r10
  0x0000000110bdad8b: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bdad91: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bdad9c: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bdada0: mov    %eax,-0x14000(%rsp)
  0x0000000110bdada7: push   %rbp
  0x0000000110bdada8: sub    $0x30,%rsp
  0x0000000110bdadac: movabs $0x10dcee0d0,%rdi  ;   {metadata(method data for {method} {0x000000010db76480} '<init>' '()V' in 'java/lang/Object')}
  0x0000000110bdadb6: mov    0xdc(%rdi),%ebx
  0x0000000110bdadbc: add    $0x8,%ebx
  0x0000000110bdadbf: mov    %ebx,0xdc(%rdi)
  0x0000000110bdadc5: movabs $0x10db76480,%rdi  ;   {metadata({method} {0x000000010db76480} '<init>' '()V' in 'java/lang/Object')}
  0x0000000110bdadcf: and    $0x1ff8,%ebx
  0x0000000110bdadd5: cmp    $0x0,%ebx
  0x0000000110bdadd8: je     0x0000000110bdadf7
  0x0000000110bdadde: mov    %rsi,%rdi          ;*return
                                                ; - java.lang.Object::<init>@0 (line 37)

  0x0000000110bdade1: mov    %rsi,0x20(%rsp)
  0x0000000110bdade6: callq  0x0000000110bc6460  ; OopMap{[32]=Oop off=107}
                                                ;*return
                                                ; - java.lang.Object::<init>@0 (line 37)
                                                ;   {runtime_call}
  0x0000000110bdadeb: add    $0x30,%rsp
  0x0000000110bdadef: pop    %rbp
  0x0000000110bdadf0: test   %eax,-0xf1e3cf6(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdadf6: retq   
  0x0000000110bdadf7: mov    %rdi,0x8(%rsp)
  0x0000000110bdadfc: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bdae04: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop off=137}
                                                ;*synchronization entry
                                                ; - java.lang.Object::<init>@-1 (line 37)
                                                ;   {runtime_call}
  0x0000000110bdae09: jmp    0x0000000110bdadde
  0x0000000110bdae0b: nop
  0x0000000110bdae0c: nop
  0x0000000110bdae0d: mov    0x2a8(%r15),%rax
  0x0000000110bdae14: movabs $0x0,%r10
  0x0000000110bdae1e: mov    %r10,0x2a8(%r15)
  0x0000000110bdae25: movabs $0x0,%r10
  0x0000000110bdae2f: mov    %r10,0x2b0(%r15)
  0x0000000110bdae36: add    $0x30,%rsp
  0x0000000110bdae3a: pop    %rbp
  0x0000000110bdae3b: jmpq   0x0000000110b38ca0  ;   {runtime_call}
[Exception Handler]
[Stub Code]
  0x0000000110bdae40: callq  0x0000000110bc80e0  ;   {no_reloc}
  0x0000000110bdae45: mov    %rsp,-0x28(%rsp)
  0x0000000110bdae4a: sub    $0x80,%rsp
  0x0000000110bdae51: mov    %rax,0x78(%rsp)
  0x0000000110bdae56: mov    %rcx,0x70(%rsp)
  0x0000000110bdae5b: mov    %rdx,0x68(%rsp)
  0x0000000110bdae60: mov    %rbx,0x60(%rsp)
  0x0000000110bdae65: mov    %rbp,0x50(%rsp)
  0x0000000110bdae6a: mov    %rsi,0x48(%rsp)
  0x0000000110bdae6f: mov    %rdi,0x40(%rsp)
  0x0000000110bdae74: mov    %r8,0x38(%rsp)
  0x0000000110bdae79: mov    %r9,0x30(%rsp)
  0x0000000110bdae7e: mov    %r10,0x28(%rsp)
  0x0000000110bdae83: mov    %r11,0x20(%rsp)
  0x0000000110bdae88: mov    %r12,0x18(%rsp)
  0x0000000110bdae8d: mov    %r13,0x10(%rsp)
  0x0000000110bdae92: mov    %r14,0x8(%rsp)
  0x0000000110bdae97: mov    %r15,(%rsp)
  0x0000000110bdae9b: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bdaea5: movabs $0x110bdae45,%rsi  ;   {internal_word}
  0x0000000110bdaeaf: mov    %rsp,%rdx
  0x0000000110bdaeb2: and    $0xfffffffffffffff0,%rsp
  0x0000000110bdaeb6: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bdaebb: hlt    
[Deopt Handler Code]
  0x0000000110bdaebc: movabs $0x110bdaebc,%r10  ;   {section_word}
  0x0000000110bdaec6: push   %r10
  0x0000000110bdaec8: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bdaecd: hlt    
  0x0000000110bdaece: hlt    
  0x0000000110bdaecf: hlt    
Decoding compiled method 0x0000000110bda150:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String'
  # this:     rsi:rsi   = 'java/lang/String'
  # parm0:    rdx:rdx   = '[C'
  # parm1:    rcx       = int
  # parm2:    r8        = int
  #           [sp+0x70]  (sp of caller)
  0x0000000110bda320: mov    0x8(%rsi),%r10d
  0x0000000110bda324: shl    $0x3,%r10
  0x0000000110bda328: cmp    %rax,%r10
  0x0000000110bda32b: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bda331: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bda33c: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bda340: mov    %eax,-0x14000(%rsp)
  0x0000000110bda347: push   %rbp
  0x0000000110bda348: sub    $0x60,%rsp
  0x0000000110bda34c: movabs $0x10dd6f388,%rdi  ;   {metadata(method data for {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda356: mov    0xdc(%rdi),%ebx
  0x0000000110bda35c: add    $0x8,%ebx
  0x0000000110bda35f: mov    %ebx,0xdc(%rdi)
  0x0000000110bda365: movabs $0x10db791a0,%rdi  ;   {metadata({method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda36f: and    $0x1ff8,%ebx
  0x0000000110bda375: cmp    $0x0,%ebx
  0x0000000110bda378: je     0x0000000110bda646  ;*aload_0
                                                ; - java.lang.String::<init>@0 (line 190)

  0x0000000110bda37e: mov    %rsi,%rdi
  0x0000000110bda381: movabs $0x10dd6f388,%rbx  ;   {metadata(method data for {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda38b: addq   $0x1,0x108(%rbx)
  0x0000000110bda393: movabs $0x10dcee0d0,%rdi  ;   {metadata(method data for {method} {0x000000010db76480} '<init>' '()V' in 'java/lang/Object')}
  0x0000000110bda39d: mov    0xdc(%rdi),%ebx
  0x0000000110bda3a3: add    $0x8,%ebx
  0x0000000110bda3a6: mov    %ebx,0xdc(%rdi)
  0x0000000110bda3ac: movabs $0x10db76480,%rdi  ;   {metadata({method} {0x000000010db76480} '<init>' '()V' in 'java/lang/Object')}
  0x0000000110bda3b6: and    $0x7ffff8,%ebx
  0x0000000110bda3bc: cmp    $0x0,%ebx
  0x0000000110bda3bf: je     0x0000000110bda65d
  0x0000000110bda3c5: cmp    $0x0,%ecx
  0x0000000110bda3c8: movabs $0x10dd6f388,%rdi  ;   {metadata(method data for {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda3d2: movabs $0x118,%rbx
  0x0000000110bda3dc: jge    0x0000000110bda3ec
  0x0000000110bda3e2: movabs $0x128,%rbx
  0x0000000110bda3ec: mov    (%rdi,%rbx,1),%rax
  0x0000000110bda3f0: lea    0x1(%rax),%rax
  0x0000000110bda3f4: mov    %rax,(%rdi,%rbx,1)
  0x0000000110bda3f8: jl     0x0000000110bda606  ;*ifge
                                                ; - java.lang.String::<init>@5 (line 191)

  0x0000000110bda3fe: cmp    $0x0,%r8d
  0x0000000110bda402: movabs $0x10dd6f388,%rdi  ;   {metadata(method data for {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda40c: movabs $0x148,%rbx
  0x0000000110bda416: jg     0x0000000110bda426
  0x0000000110bda41c: movabs $0x158,%rbx
  0x0000000110bda426: mov    (%rdi,%rbx,1),%rax
  0x0000000110bda42a: lea    0x1(%rax),%rax
  0x0000000110bda42e: mov    %rax,(%rdi,%rbx,1)
  0x0000000110bda432: jg     0x0000000110bda4ad  ;*ifgt
                                                ; - java.lang.String::<init>@18 (line 194)

  0x0000000110bda438: cmp    $0x0,%r8d
  0x0000000110bda43c: movabs $0x10dd6f388,%rdi  ;   {metadata(method data for {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda446: movabs $0x168,%rbx
  0x0000000110bda450: jge    0x0000000110bda460
  0x0000000110bda456: movabs $0x178,%rbx
  0x0000000110bda460: mov    (%rdi,%rbx,1),%rax
  0x0000000110bda464: lea    0x1(%rax),%rax
  0x0000000110bda468: mov    %rax,(%rdi,%rbx,1)
  0x0000000110bda46c: jl     0x0000000110bda5c6  ;*ifge
                                                ; - java.lang.String::<init>@22 (line 195)

  0x0000000110bda472: mov    0xc(%rdx),%edi     ;*arraylength
                                                ; - java.lang.String::<init>@36 (line 198)
                                                ; implicit exception: dispatches to 0x0000000110bda674
  0x0000000110bda475: cmp    %edi,%ecx
  0x0000000110bda477: movabs $0x10dd6f388,%rdi  ;   {metadata(method data for {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda481: movabs $0x198,%rbx
  0x0000000110bda48b: jg     0x0000000110bda49b
  0x0000000110bda491: movabs $0x1a8,%rbx
  0x0000000110bda49b: mov    (%rdi,%rbx,1),%rax
  0x0000000110bda49f: lea    0x1(%rax),%rax
  0x0000000110bda4a3: mov    %rax,(%rdi,%rbx,1)
  0x0000000110bda4a7: jle    0x0000000110bda542  ;*if_icmpgt
                                                ; - java.lang.String::<init>@37 (line 198)

  0x0000000110bda4ad: mov    0xc(%rdx),%edi     ;*arraylength
                                                ; - java.lang.String::<init>@52 (line 204)
                                                ; implicit exception: dispatches to 0x0000000110bda679
  0x0000000110bda4b0: sub    %r8d,%edi
  0x0000000110bda4b3: cmp    %edi,%ecx
  0x0000000110bda4b5: movabs $0x10dd6f388,%rdi  ;   {metadata(method data for {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda4bf: movabs $0x1b8,%rbx
  0x0000000110bda4c9: jle    0x0000000110bda4d9
  0x0000000110bda4cf: movabs $0x1c8,%rbx
  0x0000000110bda4d9: mov    (%rdi,%rbx,1),%rax
  0x0000000110bda4dd: lea    0x1(%rax),%rax
  0x0000000110bda4e1: mov    %rax,(%rdi,%rbx,1)
  0x0000000110bda4e5: jg     0x0000000110bda57c  ;*if_icmple
                                                ; - java.lang.String::<init>@55 (line 204)

  0x0000000110bda4eb: mov    %rsi,0x38(%rsp)
  0x0000000110bda4f0: movabs $0x10dd6f388,%rdi  ;   {metadata(method data for {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda4fa: addq   $0x1,0x1e8(%rdi)
  0x0000000110bda502: add    %ecx,%r8d
  0x0000000110bda505: mov    %rdx,%rsi
  0x0000000110bda508: mov    %rcx,%rdx
  0x0000000110bda50b: mov    %r8,%rcx           ;*invokestatic copyOfRange
                                                ; - java.lang.String::<init>@75 (line 207)

  0x0000000110bda50e: nop
  0x0000000110bda50f: callq  0x0000000110b11520  ; OopMap{[56]=Oop off=500}
                                                ;*invokestatic copyOfRange
                                                ; - java.lang.String::<init>@75 (line 207)
                                                ;   {static_call}
  0x0000000110bda514: mov    0x38(%rsp),%rsi
  0x0000000110bda519: mov    %rax,%r10
  0x0000000110bda51c: shr    $0x3,%r10
  0x0000000110bda520: mov    %r10d,0xc(%rsi)
  0x0000000110bda524: shr    $0x9,%rsi
  0x0000000110bda528: movabs $0x100fcf000,%rdx
  0x0000000110bda532: movb   $0x0,(%rsi,%rdx,1)  ;*putfield value
                                                ; - java.lang.String::<init>@78 (line 207)

  0x0000000110bda536: add    $0x60,%rsp
  0x0000000110bda53a: pop    %rbp
  0x0000000110bda53b: test   %eax,-0xf1e3441(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bda541: retq                      ;*return
                                                ; - java.lang.String::<init>@81 (line 208)

  0x0000000110bda542: movabs $0x76ab0a690,%rdx  ;   {oop("")}
  0x0000000110bda54c: mov    0xc(%rdx),%edx     ; implicit exception: dispatches to 0x0000000110bda67e
  0x0000000110bda54f: shl    $0x3,%rdx          ;*getfield value
                                                ; - java.lang.String::<init>@43 (line 199)

  0x0000000110bda553: mov    %rdx,%r10
  0x0000000110bda556: shr    $0x3,%r10
  0x0000000110bda55a: mov    %r10d,0xc(%rsi)
  0x0000000110bda55e: shr    $0x9,%rsi
  0x0000000110bda562: movabs $0x100fcf000,%rdx
  0x0000000110bda56c: movb   $0x0,(%rsi,%rdx,1)  ;*putfield value
                                                ; - java.lang.String::<init>@46 (line 199)

  0x0000000110bda570: add    $0x60,%rsp
  0x0000000110bda574: pop    %rbp
  0x0000000110bda575: test   %eax,-0xf1e347b(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bda57b: retq                      ;*return
                                                ; - java.lang.String::<init>@49 (line 200)

  0x0000000110bda57c: nopl   0x0(%rax)
  0x0000000110bda580: jmpq   0x0000000110bda692  ;   {no_reloc}
  0x0000000110bda585: add    %al,(%rax)
  0x0000000110bda587: add    %al,(%rax)
  0x0000000110bda589: add    %ch,%cl
  0x0000000110bda58b: or     $0x48000001,%eax   ;*new  ; - java.lang.String::<init>@58 (line 205)

  0x0000000110bda590: mov    %eax,%edx
  0x0000000110bda592: movabs $0x10dd6f388,%rsi  ;   {metadata(method data for {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda59c: addq   $0x1,0x1d8(%rsi)
  0x0000000110bda5a4: add    %ecx,%r8d
  0x0000000110bda5a7: mov    %r8,%rdx
  0x0000000110bda5aa: mov    %rax,%rsi          ;*invokespecial <init>
                                                ; - java.lang.String::<init>@65 (line 205)

  0x0000000110bda5ad: mov    %rax,0x40(%rsp)
  0x0000000110bda5b2: nop
  0x0000000110bda5b3: nop
  0x0000000110bda5b4: nop
  0x0000000110bda5b5: nop
  0x0000000110bda5b6: nop
  0x0000000110bda5b7: callq  0x0000000110b110a0  ; OopMap{[64]=Oop off=668}
                                                ;*invokespecial <init>
                                                ; - java.lang.String::<init>@65 (line 205)
                                                ;   {optimized virtual_call}
  0x0000000110bda5bc: mov    0x40(%rsp),%rax
  0x0000000110bda5c1: jmpq   0x0000000110bda720  ;*athrow
                                                ; - java.lang.String::<init>@68 (line 205)

  0x0000000110bda5c6: xchg   %ax,%ax
  0x0000000110bda5c8: jmpq   0x0000000110bda6b8  ;   {no_reloc}
  0x0000000110bda5cd: add    %al,(%rax)
  0x0000000110bda5cf: add    %al,(%rax)
  0x0000000110bda5d1: add    %ch,%cl
  0x0000000110bda5d3: jmp    0x0000000110bda5d5
  0x0000000110bda5d5: add    %al,(%rax)         ;*new  ; - java.lang.String::<init>@25 (line 196)

  0x0000000110bda5d7: mov    %rax,%rdx
  0x0000000110bda5da: movabs $0x10dd6f388,%rsi  ;   {metadata(method data for {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda5e4: addq   $0x1,0x188(%rsi)
  0x0000000110bda5ec: mov    %r8,%rdx
  0x0000000110bda5ef: mov    %rax,%rsi          ;*invokespecial <init>
                                                ; - java.lang.String::<init>@30 (line 196)

  0x0000000110bda5f2: mov    %rax,0x48(%rsp)
  0x0000000110bda5f7: callq  0x0000000110b110a0  ; OopMap{[72]=Oop off=732}
                                                ;*invokespecial <init>
                                                ; - java.lang.String::<init>@30 (line 196)
                                                ;   {optimized virtual_call}
  0x0000000110bda5fc: mov    0x48(%rsp),%rax
  0x0000000110bda601: jmpq   0x0000000110bda720  ;*athrow
                                                ; - java.lang.String::<init>@33 (line 196)

  0x0000000110bda606: xchg   %ax,%ax
  0x0000000110bda608: jmpq   0x0000000110bda6de  ;   {no_reloc}
  0x0000000110bda60d: add    %al,(%rax)
  0x0000000110bda60f: add    %al,(%rax)
  0x0000000110bda611: add    %ch,%cl
  0x0000000110bda613: roll   (%rax)
  0x0000000110bda615: add    %al,(%rax)         ;*new  ; - java.lang.String::<init>@8 (line 192)

  0x0000000110bda617: mov    %rax,%rdx
  0x0000000110bda61a: movabs $0x10dd6f388,%rsi  ;   {metadata(method data for {method} {0x000000010db791a0} '<init>' '([CII)V' in 'java/lang/String')}
  0x0000000110bda624: addq   $0x1,0x138(%rsi)
  0x0000000110bda62c: mov    %rcx,%rdx
  0x0000000110bda62f: mov    %rax,%rsi          ;*invokespecial <init>
                                                ; - java.lang.String::<init>@13 (line 192)

  0x0000000110bda632: mov    %rax,0x50(%rsp)
  0x0000000110bda637: callq  0x0000000110b110a0  ; OopMap{[80]=Oop off=796}
                                                ;*invokespecial <init>
                                                ; - java.lang.String::<init>@13 (line 192)
                                                ;   {optimized virtual_call}
  0x0000000110bda63c: mov    0x50(%rsp),%rax
  0x0000000110bda641: jmpq   0x0000000110bda720
  0x0000000110bda646: mov    %rdi,0x8(%rsp)
  0x0000000110bda64b: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bda653: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop rdx=Oop off=824}
                                                ;*synchronization entry
                                                ; - java.lang.String::<init>@-1 (line 190)
                                                ;   {runtime_call}
  0x0000000110bda658: jmpq   0x0000000110bda37e
  0x0000000110bda65d: mov    %rdi,0x8(%rsp)
  0x0000000110bda662: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bda66a: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop rdx=Oop off=847}
                                                ;*synchronization entry
                                                ; - java.lang.Object::<init>@-1 (line 37)
                                                ; - java.lang.String::<init>@1 (line 190)
                                                ;   {runtime_call}
  0x0000000110bda66f: jmpq   0x0000000110bda3c5
  0x0000000110bda674: callq  0x0000000110bc6240  ; OopMap{rsi=Oop rdx=Oop off=857}
                                                ;*arraylength
                                                ; - java.lang.String::<init>@36 (line 198)
                                                ;   {runtime_call}
  0x0000000110bda679: callq  0x0000000110bc6240  ; OopMap{rsi=Oop rdx=Oop off=862}
                                                ;*arraylength
                                                ; - java.lang.String::<init>@52 (line 204)
                                                ;   {runtime_call}
  0x0000000110bda67e: callq  0x0000000110bc6240  ; OopMap{rsi=Oop off=867}
                                                ;*getfield value
                                                ; - java.lang.String::<init>@43 (line 199)
                                                ;   {runtime_call}
  0x0000000110bda683: movabs $0x0,%rdx          ;   {metadata(NULL)}
  0x0000000110bda68d: mov    $0xa050f00,%eax
  0x0000000110bda692: callq  0x0000000110bc98a0  ; OopMap{off=887}
                                                ;*new  ; - java.lang.String::<init>@58 (line 205)
                                                ;   {runtime_call}
  0x0000000110bda697: jmpq   0x0000000110bda580
  0x0000000110bda69c: mov    %rdx,%rdx
  0x0000000110bda69f: callq  0x0000000110bc66e0  ; OopMap{off=900}
                                                ;*new  ; - java.lang.String::<init>@58 (line 205)
                                                ;   {runtime_call}
  0x0000000110bda6a4: jmpq   0x0000000110bda58f
  0x0000000110bda6a9: movabs $0x0,%rdx          ;   {metadata(NULL)}
  0x0000000110bda6b3: mov    $0xa050f00,%eax
  0x0000000110bda6b8: callq  0x0000000110bc98a0  ; OopMap{off=925}
                                                ;*new  ; - java.lang.String::<init>@25 (line 196)
                                                ;   {runtime_call}
  0x0000000110bda6bd: jmpq   0x0000000110bda5c8
  0x0000000110bda6c2: mov    %rdx,%rdx
  0x0000000110bda6c5: callq  0x0000000110bc66e0  ; OopMap{off=938}
                                                ;*new  ; - java.lang.String::<init>@25 (line 196)
                                                ;   {runtime_call}
  0x0000000110bda6ca: jmpq   0x0000000110bda5d7
  0x0000000110bda6cf: movabs $0x0,%rdx          ;   {metadata(NULL)}
  0x0000000110bda6d9: mov    $0xa050f00,%eax
  0x0000000110bda6de: callq  0x0000000110bc98a0  ; OopMap{off=963}
                                                ;*new  ; - java.lang.String::<init>@8 (line 192)
                                                ;   {runtime_call}
  0x0000000110bda6e3: jmpq   0x0000000110bda608
  0x0000000110bda6e8: mov    %rdx,%rdx
  0x0000000110bda6eb: callq  0x0000000110bc66e0  ; OopMap{off=976}
                                                ;*new  ; - java.lang.String::<init>@8 (line 192)
                                                ;   {runtime_call}
  0x0000000110bda6f0: jmpq   0x0000000110bda617
  0x0000000110bda6f5: nop
  0x0000000110bda6f6: nop
  0x0000000110bda6f7: mov    0x2a8(%r15),%rax
  0x0000000110bda6fe: movabs $0x0,%r10
  0x0000000110bda708: mov    %r10,0x2a8(%r15)
  0x0000000110bda70f: movabs $0x0,%r10
  0x0000000110bda719: mov    %r10,0x2b0(%r15)
  0x0000000110bda720: add    $0x60,%rsp
  0x0000000110bda724: pop    %rbp
  0x0000000110bda725: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bda72a: hlt    
  0x0000000110bda72b: hlt    
  0x0000000110bda72c: hlt    
  0x0000000110bda72d: hlt    
  0x0000000110bda72e: hlt    
  0x0000000110bda72f: hlt    
  0x0000000110bda730: hlt    
  0x0000000110bda731: hlt    
  0x0000000110bda732: hlt    
  0x0000000110bda733: hlt    
  0x0000000110bda734: hlt    
  0x0000000110bda735: hlt    
  0x0000000110bda736: hlt    
  0x0000000110bda737: hlt    
  0x0000000110bda738: hlt    
  0x0000000110bda739: hlt    
  0x0000000110bda73a: hlt    
  0x0000000110bda73b: hlt    
  0x0000000110bda73c: hlt    
  0x0000000110bda73d: hlt    
  0x0000000110bda73e: hlt    
  0x0000000110bda73f: hlt    
[Stub Code]
  0x0000000110bda740: nop                       ;   {no_reloc}
  0x0000000110bda741: nop
  0x0000000110bda742: nop
  0x0000000110bda743: nop
  0x0000000110bda744: nop
  0x0000000110bda745: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bda74f: jmpq   0x0000000110bda74f  ;   {runtime_call}
  0x0000000110bda754: nop
  0x0000000110bda755: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bda75f: jmpq   0x0000000110bda75f  ;   {runtime_call}
  0x0000000110bda764: nop
  0x0000000110bda765: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bda76f: jmpq   0x0000000110bda76f  ;   {runtime_call}
  0x0000000110bda774: nop
  0x0000000110bda775: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bda77f: jmpq   0x0000000110bda77f  ;   {runtime_call}
[Exception Handler]
  0x0000000110bda784: callq  0x0000000110bc80e0  ;   {runtime_call}
  0x0000000110bda789: mov    %rsp,-0x28(%rsp)
  0x0000000110bda78e: sub    $0x80,%rsp
  0x0000000110bda795: mov    %rax,0x78(%rsp)
  0x0000000110bda79a: mov    %rcx,0x70(%rsp)
  0x0000000110bda79f: mov    %rdx,0x68(%rsp)
  0x0000000110bda7a4: mov    %rbx,0x60(%rsp)
  0x0000000110bda7a9: mov    %rbp,0x50(%rsp)
  0x0000000110bda7ae: mov    %rsi,0x48(%rsp)
  0x0000000110bda7b3: mov    %rdi,0x40(%rsp)
  0x0000000110bda7b8: mov    %r8,0x38(%rsp)
  0x0000000110bda7bd: mov    %r9,0x30(%rsp)
  0x0000000110bda7c2: mov    %r10,0x28(%rsp)
  0x0000000110bda7c7: mov    %r11,0x20(%rsp)
  0x0000000110bda7cc: mov    %r12,0x18(%rsp)
  0x0000000110bda7d1: mov    %r13,0x10(%rsp)
  0x0000000110bda7d6: mov    %r14,0x8(%rsp)
  0x0000000110bda7db: mov    %r15,(%rsp)
  0x0000000110bda7df: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bda7e9: movabs $0x110bda789,%rsi  ;   {internal_word}
  0x0000000110bda7f3: mov    %rsp,%rdx
  0x0000000110bda7f6: and    $0xfffffffffffffff0,%rsp
  0x0000000110bda7fa: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bda7ff: hlt    
[Deopt Handler Code]
  0x0000000110bda800: movabs $0x110bda800,%r10  ;   {section_word}
  0x0000000110bda80a: push   %r10
  0x0000000110bda80c: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bda811: hlt    
  0x0000000110bda812: hlt    
  0x0000000110bda813: hlt    
  0x0000000110bda814: hlt    
  0x0000000110bda815: hlt    
  0x0000000110bda816: hlt    
  0x0000000110bda817: hlt    
Decoding compiled method 0x0000000110bd8c10:
Code:
[Entry Point]
[Verified Entry Point]
[Constants]
  # {method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays'
  # parm0:    rsi:rsi   = '[C'
  # parm1:    rdx       = int
  # parm2:    rcx       = int
  #           [sp+0xb0]  (sp of caller)
  0x0000000110bd8e20: mov    %eax,-0x14000(%rsp)
  0x0000000110bd8e27: push   %rbp
  0x0000000110bd8e28: sub    $0xa0,%rsp
  0x0000000110bd8e2f: mov    %rsi,%r8
  0x0000000110bd8e32: mov    %rdx,%r9
  0x0000000110bd8e35: movabs $0x10dd71730,%rbx  ;   {metadata(method data for {method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays')}
  0x0000000110bd8e3f: mov    0xdc(%rbx),%edx
  0x0000000110bd8e45: add    $0x8,%edx
  0x0000000110bd8e48: mov    %edx,0xdc(%rbx)
  0x0000000110bd8e4e: movabs $0x10dc91c80,%rbx  ;   {metadata({method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays')}
  0x0000000110bd8e58: and    $0x1ff8,%edx
  0x0000000110bd8e5e: cmp    $0x0,%edx
  0x0000000110bd8e61: je     0x0000000110bd96c1  ;*iload_2
                                                ; - java.util.Arrays::copyOfRange@0 (line 3661)

  0x0000000110bd8e67: mov    %rcx,%r11
  0x0000000110bd8e6a: sub    %r9d,%r11d
  0x0000000110bd8e6d: cmp    $0x0,%r11d
  0x0000000110bd8e71: movabs $0x10dd71730,%rbx  ;   {metadata(method data for {method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays')}
  0x0000000110bd8e7b: movabs $0x108,%rdx
  0x0000000110bd8e85: jge    0x0000000110bd8e95
  0x0000000110bd8e8b: movabs $0x118,%rdx
  0x0000000110bd8e95: mov    (%rbx,%rdx,1),%rsi
  0x0000000110bd8e99: lea    0x1(%rsi),%rsi
  0x0000000110bd8e9d: mov    %rsi,(%rbx,%rdx,1)
  0x0000000110bd8ea1: jl     0x0000000110bd9064  ;*ifge
                                                ; - java.util.Arrays::copyOfRange@5 (line 3662)

  0x0000000110bd8ea7: mov    %r11,%rbx
  0x0000000110bd8eaa: movabs $0x7c0000208,%rdx  ;   {metadata({type array char})}
  0x0000000110bd8eb4: movslq %ebx,%rbx
  0x0000000110bd8eb7: mov    %rbx,%rdi
  0x0000000110bd8eba: cmp    $0xffffff,%rbx
  0x0000000110bd8ec1: ja     0x0000000110bd96d8
  0x0000000110bd8ec7: movabs $0x17,%rsi
  0x0000000110bd8ed1: lea    (%rsi,%rbx,2),%rsi
  0x0000000110bd8ed5: and    $0xfffffffffffffff8,%rsi
  0x0000000110bd8ed9: mov    0x60(%r15),%rax
  0x0000000110bd8edd: lea    (%rax,%rsi,1),%rsi
  0x0000000110bd8ee1: cmp    0x70(%r15),%rsi
  0x0000000110bd8ee5: ja     0x0000000110bd96d8
  0x0000000110bd8eeb: mov    %rsi,0x60(%r15)
  0x0000000110bd8eef: sub    %rax,%rsi
  0x0000000110bd8ef2: movq   $0x1,(%rax)
  0x0000000110bd8ef9: mov    %rdx,%rcx
  0x0000000110bd8efc: shr    $0x3,%rcx
  0x0000000110bd8f00: mov    %ecx,0x8(%rax)
  0x0000000110bd8f03: mov    %ebx,0xc(%rax)
  0x0000000110bd8f06: sub    $0x10,%rsi
  0x0000000110bd8f0a: je     0x0000000110bd8f21
  0x0000000110bd8f10: xor    %rbx,%rbx
  0x0000000110bd8f13: shr    $0x3,%rsi
  0x0000000110bd8f17: mov    %rbx,0x8(%rax,%rsi,8)
  0x0000000110bd8f1c: dec    %rsi
  0x0000000110bd8f1f: jne    0x0000000110bd8f17  ;*newarray
                                                ; - java.util.Arrays::copyOfRange@40 (line 3664)

  0x0000000110bd8f21: mov    0xc(%r8),%esi      ;*arraylength
                                                ; - java.util.Arrays::copyOfRange@50 (line 3665)
                                                ; implicit exception: dispatches to 0x0000000110bd96e2
  0x0000000110bd8f25: sub    %r9d,%esi
  0x0000000110bd8f28: movabs $0x10dd71730,%rdx  ;   {metadata(method data for {method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays')}
  0x0000000110bd8f32: addq   $0x1,0x208(%rdx)
  0x0000000110bd8f3a: movabs $0x10dd43210,%rdx  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bd8f44: mov    0xdc(%rdx),%ecx
  0x0000000110bd8f4a: add    $0x8,%ecx
  0x0000000110bd8f4d: mov    %ecx,0xdc(%rdx)
  0x0000000110bd8f53: movabs $0x10dc6cd70,%rdx  ;   {metadata({method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bd8f5d: and    $0x7ffff8,%ecx
  0x0000000110bd8f63: cmp    $0x0,%ecx
  0x0000000110bd8f66: je     0x0000000110bd96e7
  0x0000000110bd8f6c: cmp    %r11d,%esi
  0x0000000110bd8f6f: movabs $0x10dd43210,%rdx  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bd8f79: movabs $0x108,%rcx
  0x0000000110bd8f83: jg     0x0000000110bd8f93
  0x0000000110bd8f89: movabs $0x118,%rcx
  0x0000000110bd8f93: mov    (%rdx,%rcx,1),%rdi
  0x0000000110bd8f97: lea    0x1(%rdi),%rdi
  0x0000000110bd8f9b: mov    %rdi,(%rdx,%rcx,1)
  0x0000000110bd8f9f: jg     0x0000000110bd8fbd  ;*if_icmpgt
                                                ; - java.lang.Math::min@2 (line 1336)
                                                ; - java.util.Arrays::copyOfRange@54 (line 3666)

  0x0000000110bd8fa5: movabs $0x10dd43210,%rdx  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bd8faf: incl   0x128(%rdx)
  0x0000000110bd8fb5: mov    %rsi,%rdi
  0x0000000110bd8fb8: jmpq   0x0000000110bd8fc0  ;*goto
                                                ; - java.lang.Math::min@6 (line 1336)
                                                ; - java.util.Arrays::copyOfRange@54 (line 3666)

  0x0000000110bd8fbd: mov    %r11,%rdi          ;*ireturn
                                                ; - java.lang.Math::min@10 (line 1336)
                                                ; - java.util.Arrays::copyOfRange@54 (line 3666)

  0x0000000110bd8fc0: movabs $0x10dd71730,%rsi  ;   {metadata(method data for {method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays')}
  0x0000000110bd8fca: addq   $0x1,0x218(%rsi)
  0x0000000110bd8fd2: mov    %r8,%rsi
  0x0000000110bd8fd5: mov    %r9,%rdx
  0x0000000110bd8fd8: mov    %rax,%rcx
  0x0000000110bd8fdb: mov    $0x0,%r8d
  0x0000000110bd8fe1: mov    %rdi,%r9
  0x0000000110bd8fe4: mov    %rax,0x70(%rsp)
  0x0000000110bd8fe9: test   %edx,%edx
  0x0000000110bd8feb: jl     0x0000000110bd96fe
  0x0000000110bd8ff1: lea    (%rdx,%r9,1),%rdi
  0x0000000110bd8ff5: cmp    0xc(%rsi),%edi
  0x0000000110bd8ff8: ja     0x0000000110bd96fe
  0x0000000110bd8ffe: lea    (%r8,%r9,1),%rdi
  0x0000000110bd9002: cmp    0xc(%rcx),%edi
  0x0000000110bd9005: ja     0x0000000110bd96fe
  0x0000000110bd900b: test   %r9d,%r9d
  0x0000000110bd900e: jl     0x0000000110bd96fe
  0x0000000110bd9014: je     0x0000000110bd9050
  0x0000000110bd901a: movslq %edx,%rdx
  0x0000000110bd901d: movslq %r8d,%r8
  0x0000000110bd9020: lea    0x10(%rsi,%rdx,2),%rdi
  0x0000000110bd9025: lea    0x10(%rcx,%r8,2),%rsi
  0x0000000110bd902a: mov    %r9,%rdx
  0x0000000110bd902d: test   $0xf,%esp
  0x0000000110bd9033: je     0x0000000110bd904b
  0x0000000110bd9039: sub    $0x8,%rsp
  0x0000000110bd903d: callq  Stub::jshort_disjoint_arraycopy
                                                ;   {runtime_call}
  0x0000000110bd9042: add    $0x8,%rsp
  0x0000000110bd9046: jmpq   0x0000000110bd9050
  0x0000000110bd904b: callq  Stub::jshort_disjoint_arraycopy
                                                ;*invokestatic arraycopy
                                                ; - java.util.Arrays::copyOfRange@57 (line 3665)
                                                ;   {runtime_call}
  0x0000000110bd9050: mov    0x70(%rsp),%rax
  0x0000000110bd9055: add    $0xa0,%rsp
  0x0000000110bd905c: pop    %rbp
  0x0000000110bd905d: test   %eax,-0xf1e1f63(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bd9063: retq                      ;*areturn
                                                ; - java.util.Arrays::copyOfRange@62 (line 3667)

  0x0000000110bd9064: mov    %ecx,0x80(%rsp)
  0x0000000110bd906b: nopl   0x0(%rax,%rax,1)
  0x0000000110bd9070: jmpq   0x0000000110bd9718  ;   {no_reloc}
  0x0000000110bd9075: add    %al,(%rax)
  0x0000000110bd9077: add    %al,(%rax)
  0x0000000110bd9079: add    %cl,-0x75(%rcx)
  0x0000000110bd907c: rex.RXB (bad) 
  0x0000000110bd907e: lea    0x20(%rax),%rdi
  0x0000000110bd9082: cmp    0x70(%r15),%rdi
  0x0000000110bd9086: ja     0x0000000110bd9722
  0x0000000110bd908c: mov    %rdi,0x60(%r15)
  0x0000000110bd9090: mov    0xa8(%rdx),%rcx
  0x0000000110bd9097: mov    %rcx,(%rax)
  0x0000000110bd909a: mov    %rdx,%rcx
  0x0000000110bd909d: shr    $0x3,%rcx
  0x0000000110bd90a1: mov    %ecx,0x8(%rax)
  0x0000000110bd90a4: xor    %rcx,%rcx
  0x0000000110bd90a7: mov    %ecx,0xc(%rax)
  0x0000000110bd90aa: xor    %rcx,%rcx
  0x0000000110bd90ad: mov    %rcx,0x10(%rax)
  0x0000000110bd90b1: mov    %rcx,0x18(%rax)    ;*new  ; - java.util.Arrays::copyOfRange@8 (line 3663)

  0x0000000110bd90b5: data16 xchg %ax,%ax
  0x0000000110bd90b8: jmpq   0x0000000110bd973e  ;   {no_reloc}
  0x0000000110bd90bd: add    %al,(%rax)
  0x0000000110bd90bf: add    %al,(%rax)
  0x0000000110bd90c1: add    %cl,-0x77(%rax)
  0x0000000110bd90c4: test   %ah,(%rax,%rcx,4)
  0x0000000110bd90c7: add    %al,(%rax)
  0x0000000110bd90c9: add    %cl,-0x75(%rcx)
  0x0000000110bd90cc: rex.RXB (bad) 
  0x0000000110bd90ce: lea    0x18(%rax),%rdi
  0x0000000110bd90d2: cmp    0x70(%r15),%rdi
  0x0000000110bd90d6: ja     0x0000000110bd9748
  0x0000000110bd90dc: mov    %rdi,0x60(%r15)
  0x0000000110bd90e0: mov    0xa8(%rdx),%rcx
  0x0000000110bd90e7: mov    %rcx,(%rax)
  0x0000000110bd90ea: mov    %rdx,%rcx
  0x0000000110bd90ed: shr    $0x3,%rcx
  0x0000000110bd90f1: mov    %ecx,0x8(%rax)
  0x0000000110bd90f4: xor    %rcx,%rcx
  0x0000000110bd90f7: mov    %ecx,0xc(%rax)
  0x0000000110bd90fa: xor    %rcx,%rcx
  0x0000000110bd90fd: mov    %rcx,0x10(%rax)    ;*new  ; - java.util.Arrays::copyOfRange@12 (line 3663)

  0x0000000110bd9101: mov    %rax,%rbx
  0x0000000110bd9104: movabs $0x10dd71730,%rdx  ;   {metadata(method data for {method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays')}
  0x0000000110bd910e: addq   $0x1,0x128(%rdx)
  0x0000000110bd9116: movabs $0x10dd75a68,%rbx  ;   {metadata(method data for {method} {0x000000010dbef060} '<init>' '()V' in 'java/lang/StringBuilder')}
  0x0000000110bd9120: mov    0xdc(%rbx),%edx
  0x0000000110bd9126: add    $0x8,%edx
  0x0000000110bd9129: mov    %edx,0xdc(%rbx)
  0x0000000110bd912f: movabs $0x10dbef060,%rbx  ;   {metadata({method} {0x000000010dbef060} '<init>' '()V' in 'java/lang/StringBuilder')}
  0x0000000110bd9139: and    $0x7ffff8,%edx
  0x0000000110bd913f: cmp    $0x0,%edx
  0x0000000110bd9142: je     0x0000000110bd9755
  0x0000000110bd9148: mov    %rax,%rbx
  0x0000000110bd914b: movabs $0x10dd75a68,%rdx  ;   {metadata(method data for {method} {0x000000010dbef060} '<init>' '()V' in 'java/lang/StringBuilder')}
  0x0000000110bd9155: addq   $0x1,0x108(%rdx)
  0x0000000110bd915d: movabs $0x10dd75ed0,%rbx  ;   {metadata(method data for {method} {0x000000010dbeb390} '<init>' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bd9167: mov    0xdc(%rbx),%edx
  0x0000000110bd916d: add    $0x8,%edx
  0x0000000110bd9170: mov    %edx,0xdc(%rbx)
  0x0000000110bd9176: movabs $0x10dbeb390,%rbx  ;   {metadata({method} {0x000000010dbeb390} '<init>' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bd9180: and    $0x7ffff8,%edx
  0x0000000110bd9186: cmp    $0x0,%edx
  0x0000000110bd9189: je     0x0000000110bd976c
  0x0000000110bd918f: mov    %rax,%rbx
  0x0000000110bd9192: movabs $0x10dd75ed0,%rdx  ;   {metadata(method data for {method} {0x000000010dbeb390} '<init>' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bd919c: addq   $0x1,0x108(%rdx)
  0x0000000110bd91a4: movabs $0x10dcee0d0,%rbx  ;   {metadata(method data for {method} {0x000000010db76480} '<init>' '()V' in 'java/lang/Object')}
  0x0000000110bd91ae: mov    0xdc(%rbx),%edx
  0x0000000110bd91b4: add    $0x8,%edx
  0x0000000110bd91b7: mov    %edx,0xdc(%rbx)
  0x0000000110bd91bd: movabs $0x10db76480,%rbx  ;   {metadata({method} {0x000000010db76480} '<init>' '()V' in 'java/lang/Object')}
  0x0000000110bd91c7: and    $0x7ffff8,%edx
  0x0000000110bd91cd: cmp    $0x0,%edx
  0x0000000110bd91d0: je     0x0000000110bd9783
  0x0000000110bd91d6: mov    $0x10,%ebx
  0x0000000110bd91db: movabs $0x7c0000208,%rdx  ;   {metadata({type array char})}
  0x0000000110bd91e5: mov    %rax,%r13
  0x0000000110bd91e8: movslq %ebx,%rbx
  0x0000000110bd91eb: mov    %rbx,%rdi
  0x0000000110bd91ee: cmp    $0xffffff,%rbx
  0x0000000110bd91f5: ja     0x0000000110bd979a
  0x0000000110bd91fb: movabs $0x17,%rsi
  0x0000000110bd9205: lea    (%rsi,%rbx,2),%rsi
  0x0000000110bd9209: and    $0xfffffffffffffff8,%rsi
  0x0000000110bd920d: mov    0x60(%r15),%rax
  0x0000000110bd9211: lea    (%rax,%rsi,1),%rsi
  0x0000000110bd9215: cmp    0x70(%r15),%rsi
  0x0000000110bd9219: ja     0x0000000110bd979a
  0x0000000110bd921f: mov    %rsi,0x60(%r15)
  0x0000000110bd9223: sub    %rax,%rsi
  0x0000000110bd9226: movq   $0x1,(%rax)
  0x0000000110bd922d: mov    %rdx,%rcx
  0x0000000110bd9230: shr    $0x3,%rcx
  0x0000000110bd9234: mov    %ecx,0x8(%rax)
  0x0000000110bd9237: mov    %ebx,0xc(%rax)
  0x0000000110bd923a: sub    $0x10,%rsi
  0x0000000110bd923e: je     0x0000000110bd9255
  0x0000000110bd9244: xor    %rbx,%rbx
  0x0000000110bd9247: shr    $0x3,%rsi
  0x0000000110bd924b: mov    %rbx,0x8(%rax,%rsi,8)
  0x0000000110bd9250: dec    %rsi
  0x0000000110bd9253: jne    0x0000000110bd924b  ;*newarray
                                                ; - java.lang.AbstractStringBuilder::<init>@6 (line 68)
                                                ; - java.lang.StringBuilder::<init>@3 (line 89)
                                                ; - java.util.Arrays::copyOfRange@16 (line 3663)

  0x0000000110bd9255: mov    %rax,%r10
  0x0000000110bd9258: shr    $0x3,%r10
  0x0000000110bd925c: mov    %r10d,0x10(%r13)
  0x0000000110bd9260: mov    %r13,%rax
  0x0000000110bd9263: shr    $0x9,%rax
  0x0000000110bd9267: movabs $0x100fcf000,%rdx
  0x0000000110bd9271: movb   $0x0,(%rax,%rdx,1)  ;*putfield value
                                                ; - java.lang.AbstractStringBuilder::<init>@8 (line 68)
                                                ; - java.lang.StringBuilder::<init>@3 (line 89)
                                                ; - java.util.Arrays::copyOfRange@16 (line 3663)

  0x0000000110bd9275: mov    %r13,%rax
  0x0000000110bd9278: movabs $0x10dd71730,%rdx  ;   {metadata(method data for {method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays')}
  0x0000000110bd9282: mov    0x8(%rax),%eax
  0x0000000110bd9285: shl    $0x3,%rax
  0x0000000110bd9289: cmp    0x140(%rdx),%rax
  0x0000000110bd9290: jne    0x0000000110bd929f
  0x0000000110bd9292: addq   $0x1,0x148(%rdx)
  0x0000000110bd929a: jmpq   0x0000000110bd9305
  0x0000000110bd929f: cmp    0x150(%rdx),%rax
  0x0000000110bd92a6: jne    0x0000000110bd92b5
  0x0000000110bd92a8: addq   $0x1,0x158(%rdx)
  0x0000000110bd92b0: jmpq   0x0000000110bd9305
  0x0000000110bd92b5: cmpq   $0x0,0x140(%rdx)
  0x0000000110bd92c0: jne    0x0000000110bd92d9
  0x0000000110bd92c2: mov    %rax,0x140(%rdx)
  0x0000000110bd92c9: movq   $0x1,0x148(%rdx)
  0x0000000110bd92d4: jmpq   0x0000000110bd9305
  0x0000000110bd92d9: cmpq   $0x0,0x150(%rdx)
  0x0000000110bd92e4: jne    0x0000000110bd92fd
  0x0000000110bd92e6: mov    %rax,0x150(%rdx)
  0x0000000110bd92ed: movq   $0x1,0x158(%rdx)
  0x0000000110bd92f8: jmpq   0x0000000110bd9305
  0x0000000110bd92fd: addq   $0x1,0x138(%rdx)
  0x0000000110bd9305: movabs $0x10dd778e0,%rdx  ;   {metadata(method data for {method} {0x000000010dbef838} 'append' '(I)Ljava/lang/StringBuilder;' in 'java/lang/StringBuilder')}
  0x0000000110bd930f: mov    0xdc(%rdx),%esi
  0x0000000110bd9315: add    $0x8,%esi
  0x0000000110bd9318: mov    %esi,0xdc(%rdx)
  0x0000000110bd931e: movabs $0x10dbef838,%rdx  ;   {metadata({method} {0x000000010dbef838} 'append' '(I)Ljava/lang/StringBuilder;' in 'java/lang/StringBuilder')}
  0x0000000110bd9328: and    $0x7ffff8,%esi
  0x0000000110bd932e: cmp    $0x0,%esi
  0x0000000110bd9331: je     0x0000000110bd97a4
  0x0000000110bd9337: mov    %r13,%rax
  0x0000000110bd933a: movabs $0x10dd778e0,%rdx  ;   {metadata(method data for {method} {0x000000010dbef838} 'append' '(I)Ljava/lang/StringBuilder;' in 'java/lang/StringBuilder')}
  0x0000000110bd9344: addq   $0x1,0x108(%rdx)
  0x0000000110bd934c: mov    %r9,%rdx
  0x0000000110bd934f: mov    %r13,%rsi          ;*invokespecial append
                                                ; - java.lang.StringBuilder::append@2 (line 208)
                                                ; - java.util.Arrays::copyOfRange@20 (line 3663)

  0x0000000110bd9352: mov    %r13,0x78(%rsp)
  0x0000000110bd9357: callq  0x0000000110b110a0  ; OopMap{[120]=Oop [136]=Oop off=1340}
                                                ;*invokespecial append
                                                ; - java.lang.StringBuilder::append@2 (line 208)
                                                ; - java.util.Arrays::copyOfRange@20 (line 3663)
                                                ;   {optimized virtual_call}
  0x0000000110bd935c: mov    0x78(%rsp),%rax
  0x0000000110bd9361: movabs $0x10dd71730,%rdx  ;   {metadata(method data for {method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays')}
  0x0000000110bd936b: mov    0x8(%rax),%eax
  0x0000000110bd936e: shl    $0x3,%rax
  0x0000000110bd9372: cmp    0x170(%rdx),%rax
  0x0000000110bd9379: jne    0x0000000110bd9388
  0x0000000110bd937b: addq   $0x1,0x178(%rdx)
  0x0000000110bd9383: jmpq   0x0000000110bd93ee
  0x0000000110bd9388: cmp    0x180(%rdx),%rax
  0x0000000110bd938f: jne    0x0000000110bd939e
  0x0000000110bd9391: addq   $0x1,0x188(%rdx)
  0x0000000110bd9399: jmpq   0x0000000110bd93ee
  0x0000000110bd939e: cmpq   $0x0,0x170(%rdx)
  0x0000000110bd93a9: jne    0x0000000110bd93c2
  0x0000000110bd93ab: mov    %rax,0x170(%rdx)
  0x0000000110bd93b2: movq   $0x1,0x178(%rdx)
  0x0000000110bd93bd: jmpq   0x0000000110bd93ee
  0x0000000110bd93c2: cmpq   $0x0,0x180(%rdx)
  0x0000000110bd93cd: jne    0x0000000110bd93e6
  0x0000000110bd93cf: mov    %rax,0x180(%rdx)
  0x0000000110bd93d6: movq   $0x1,0x188(%rdx)
  0x0000000110bd93e1: jmpq   0x0000000110bd93ee
  0x0000000110bd93e6: addq   $0x1,0x168(%rdx)
  0x0000000110bd93ee: movabs $0x10dd78b20,%rdx  ;   {metadata(method data for {method} {0x000000010dbef378} 'append' '(Ljava/lang/String;)Ljava/lang/StringBuilder;' in 'java/lang/StringBuilder')}
  0x0000000110bd93f8: mov    0xdc(%rdx),%esi
  0x0000000110bd93fe: add    $0x8,%esi
  0x0000000110bd9401: mov    %esi,0xdc(%rdx)
  0x0000000110bd9407: movabs $0x10dbef378,%rdx  ;   {metadata({method} {0x000000010dbef378} 'append' '(Ljava/lang/String;)Ljava/lang/StringBuilder;' in 'java/lang/StringBuilder')}
  0x0000000110bd9411: and    $0x7ffff8,%esi
  0x0000000110bd9417: cmp    $0x0,%esi
  0x0000000110bd941a: je     0x0000000110bd97bb
  0x0000000110bd9420: mov    0x78(%rsp),%rax
  0x0000000110bd9425: movabs $0x10dd78b20,%rdx  ;   {metadata(method data for {method} {0x000000010dbef378} 'append' '(Ljava/lang/String;)Ljava/lang/StringBuilder;' in 'java/lang/StringBuilder')}
  0x0000000110bd942f: addq   $0x1,0x108(%rdx)
  0x0000000110bd9437: movabs $0x76ac47af0,%rdx  ;   {oop(" > ")}
  0x0000000110bd9441: mov    0x78(%rsp),%rsi    ;*invokespecial append
                                                ; - java.lang.StringBuilder::append@2 (line 136)
                                                ; - java.util.Arrays::copyOfRange@25 (line 3663)

  0x0000000110bd9446: nop
  0x0000000110bd9447: callq  0x0000000110b110a0  ; OopMap{[120]=Oop [136]=Oop off=1580}
                                                ;*invokespecial append
                                                ; - java.lang.StringBuilder::append@2 (line 136)
                                                ; - java.util.Arrays::copyOfRange@25 (line 3663)
                                                ;   {optimized virtual_call}
  0x0000000110bd944c: mov    0x78(%rsp),%rax
  0x0000000110bd9451: movabs $0x10dd71730,%rdx  ;   {metadata(method data for {method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays')}
  0x0000000110bd945b: mov    0x8(%rax),%eax
  0x0000000110bd945e: shl    $0x3,%rax
  0x0000000110bd9462: cmp    0x1a0(%rdx),%rax
  0x0000000110bd9469: jne    0x0000000110bd9478
  0x0000000110bd946b: addq   $0x1,0x1a8(%rdx)
  0x0000000110bd9473: jmpq   0x0000000110bd94de
  0x0000000110bd9478: cmp    0x1b0(%rdx),%rax
  0x0000000110bd947f: jne    0x0000000110bd948e
  0x0000000110bd9481: addq   $0x1,0x1b8(%rdx)
  0x0000000110bd9489: jmpq   0x0000000110bd94de
  0x0000000110bd948e: cmpq   $0x0,0x1a0(%rdx)
  0x0000000110bd9499: jne    0x0000000110bd94b2
  0x0000000110bd949b: mov    %rax,0x1a0(%rdx)
  0x0000000110bd94a2: movq   $0x1,0x1a8(%rdx)
  0x0000000110bd94ad: jmpq   0x0000000110bd94de
  0x0000000110bd94b2: cmpq   $0x0,0x1b0(%rdx)
  0x0000000110bd94bd: jne    0x0000000110bd94d6
  0x0000000110bd94bf: mov    %rax,0x1b0(%rdx)
  0x0000000110bd94c6: movq   $0x1,0x1b8(%rdx)
  0x0000000110bd94d1: jmpq   0x0000000110bd94de
  0x0000000110bd94d6: addq   $0x1,0x198(%rdx)
  0x0000000110bd94de: movabs $0x10dd778e0,%rdx  ;   {metadata(method data for {method} {0x000000010dbef838} 'append' '(I)Ljava/lang/StringBuilder;' in 'java/lang/StringBuilder')}
  0x0000000110bd94e8: mov    0xdc(%rdx),%esi
  0x0000000110bd94ee: add    $0x8,%esi
  0x0000000110bd94f1: mov    %esi,0xdc(%rdx)
  0x0000000110bd94f7: movabs $0x10dbef838,%rdx  ;   {metadata({method} {0x000000010dbef838} 'append' '(I)Ljava/lang/StringBuilder;' in 'java/lang/StringBuilder')}
  0x0000000110bd9501: and    $0x7ffff8,%esi
  0x0000000110bd9507: cmp    $0x0,%esi
  0x0000000110bd950a: je     0x0000000110bd97d2
  0x0000000110bd9510: mov    0x78(%rsp),%rax
  0x0000000110bd9515: movabs $0x10dd778e0,%rdx  ;   {metadata(method data for {method} {0x000000010dbef838} 'append' '(I)Ljava/lang/StringBuilder;' in 'java/lang/StringBuilder')}
  0x0000000110bd951f: addq   $0x1,0x108(%rdx)
  0x0000000110bd9527: mov    0x80(%rsp),%edx
  0x0000000110bd952e: mov    0x78(%rsp),%rsi    ;*invokespecial append
                                                ; - java.lang.StringBuilder::append@2 (line 208)
                                                ; - java.util.Arrays::copyOfRange@29 (line 3663)

  0x0000000110bd9533: nop
  0x0000000110bd9534: nop
  0x0000000110bd9535: nop
  0x0000000110bd9536: nop
  0x0000000110bd9537: callq  0x0000000110b110a0  ; OopMap{[120]=Oop [136]=Oop off=1820}
                                                ;*invokespecial append
                                                ; - java.lang.StringBuilder::append@2 (line 208)
                                                ; - java.util.Arrays::copyOfRange@29 (line 3663)
                                                ;   {optimized virtual_call}
  0x0000000110bd953c: mov    0x78(%rsp),%rax
  0x0000000110bd9541: movabs $0x10dd71730,%rdx  ;   {metadata(method data for {method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays')}
  0x0000000110bd954b: mov    0x8(%rax),%eax
  0x0000000110bd954e: shl    $0x3,%rax
  0x0000000110bd9552: cmp    0x1d0(%rdx),%rax
  0x0000000110bd9559: jne    0x0000000110bd9568
  0x0000000110bd955b: addq   $0x1,0x1d8(%rdx)
  0x0000000110bd9563: jmpq   0x0000000110bd95ce
  0x0000000110bd9568: cmp    0x1e0(%rdx),%rax
  0x0000000110bd956f: jne    0x0000000110bd957e
  0x0000000110bd9571: addq   $0x1,0x1e8(%rdx)
  0x0000000110bd9579: jmpq   0x0000000110bd95ce
  0x0000000110bd957e: cmpq   $0x0,0x1d0(%rdx)
  0x0000000110bd9589: jne    0x0000000110bd95a2
  0x0000000110bd958b: mov    %rax,0x1d0(%rdx)
  0x0000000110bd9592: movq   $0x1,0x1d8(%rdx)
  0x0000000110bd959d: jmpq   0x0000000110bd95ce
  0x0000000110bd95a2: cmpq   $0x0,0x1e0(%rdx)
  0x0000000110bd95ad: jne    0x0000000110bd95c6
  0x0000000110bd95af: mov    %rax,0x1e0(%rdx)
  0x0000000110bd95b6: movq   $0x1,0x1e8(%rdx)
  0x0000000110bd95c1: jmpq   0x0000000110bd95ce
  0x0000000110bd95c6: addq   $0x1,0x1c8(%rdx)
  0x0000000110bd95ce: movabs $0x10dd79b90,%rdx  ;   {metadata(method data for {method} {0x000000010dbf0728} 'toString' '()Ljava/lang/String;' in 'java/lang/StringBuilder')}
  0x0000000110bd95d8: mov    0xdc(%rdx),%esi
  0x0000000110bd95de: add    $0x8,%esi
  0x0000000110bd95e1: mov    %esi,0xdc(%rdx)
  0x0000000110bd95e7: movabs $0x10dbf0728,%rdx  ;   {metadata({method} {0x000000010dbf0728} 'toString' '()Ljava/lang/String;' in 'java/lang/StringBuilder')}
  0x0000000110bd95f1: and    $0x7ffff8,%esi
  0x0000000110bd95f7: cmp    $0x0,%esi
  0x0000000110bd95fa: je     0x0000000110bd97e9
  0x0000000110bd9600: movabs $0x7c00016d0,%rdx  ;   {metadata('java/lang/String')}
  0x0000000110bd960a: mov    0x60(%r15),%rax
  0x0000000110bd960e: lea    0x18(%rax),%rdi
  0x0000000110bd9612: cmp    0x70(%r15),%rdi
  0x0000000110bd9616: ja     0x0000000110bd9800
  0x0000000110bd961c: mov    %rdi,0x60(%r15)
  0x0000000110bd9620: mov    0xa8(%rdx),%rcx
  0x0000000110bd9627: mov    %rcx,(%rax)
  0x0000000110bd962a: mov    %rdx,%rcx
  0x0000000110bd962d: shr    $0x3,%rcx
  0x0000000110bd9631: mov    %ecx,0x8(%rax)
  0x0000000110bd9634: xor    %rcx,%rcx
  0x0000000110bd9637: mov    %ecx,0xc(%rax)
  0x0000000110bd963a: xor    %rcx,%rcx
  0x0000000110bd963d: mov    %rcx,0x10(%rax)    ;*new  ; - java.lang.StringBuilder::toString@0 (line 407)
                                                ; - java.util.Arrays::copyOfRange@32 (line 3663)

  0x0000000110bd9641: mov    0x78(%rsp),%rdx
  0x0000000110bd9646: mov    0x10(%rdx),%ecx
  0x0000000110bd9649: shl    $0x3,%rcx          ;*getfield value
                                                ; - java.lang.StringBuilder::toString@5 (line 407)
                                                ; - java.util.Arrays::copyOfRange@32 (line 3663)

  0x0000000110bd964d: mov    0xc(%rdx),%r8d     ;*getfield count
                                                ; - java.lang.StringBuilder::toString@10 (line 407)
                                                ; - java.util.Arrays::copyOfRange@32 (line 3663)

  0x0000000110bd9651: mov    %rax,%rdx
  0x0000000110bd9654: movabs $0x10dd79b90,%rsi  ;   {metadata(method data for {method} {0x000000010dbf0728} 'toString' '()Ljava/lang/String;' in 'java/lang/StringBuilder')}
  0x0000000110bd965e: addq   $0x1,0x108(%rsi)
  0x0000000110bd9666: mov    %rcx,%rdx
  0x0000000110bd9669: mov    $0x0,%ecx
  0x0000000110bd966e: mov    %rax,%rsi          ;*invokespecial <init>
                                                ; - java.lang.StringBuilder::toString@13 (line 407)
                                                ; - java.util.Arrays::copyOfRange@32 (line 3663)

  0x0000000110bd9671: mov    %rax,0x90(%rsp)
  0x0000000110bd9679: nop
  0x0000000110bd967a: nop
  0x0000000110bd967b: nop
  0x0000000110bd967c: nop
  0x0000000110bd967d: nop
  0x0000000110bd967e: nop
  0x0000000110bd967f: callq  0x0000000110b110a0  ; OopMap{[136]=Oop [144]=Oop off=2148}
                                                ;*invokespecial <init>
                                                ; - java.lang.StringBuilder::toString@13 (line 407)
                                                ; - java.util.Arrays::copyOfRange@32 (line 3663)
                                                ;   {optimized virtual_call}
  0x0000000110bd9684: mov    0x88(%rsp),%rax
  0x0000000110bd968c: movabs $0x10dd71730,%rdx  ;   {metadata(method data for {method} {0x000000010dc91c80} 'copyOfRange' '([CII)[C' in 'java/util/Arrays')}
  0x0000000110bd9696: addq   $0x1,0x1f8(%rdx)
  0x0000000110bd969e: mov    0x90(%rsp),%rdx
  0x0000000110bd96a6: mov    0x88(%rsp),%rsi    ;*invokespecial <init>
                                                ; - java.util.Arrays::copyOfRange@35 (line 3663)

  0x0000000110bd96ae: nop
  0x0000000110bd96af: callq  0x0000000110b110a0  ; OopMap{[136]=Oop off=2196}
                                                ;*invokespecial <init>
                                                ; - java.util.Arrays::copyOfRange@35 (line 3663)
                                                ;   {optimized virtual_call}
  0x0000000110bd96b4: mov    0x88(%rsp),%rax
  0x0000000110bd96bc: jmpq   0x0000000110bd9838
  0x0000000110bd96c1: mov    %rbx,0x8(%rsp)
  0x0000000110bd96c6: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bd96ce: callq  0x0000000110bca9e0  ; OopMap{r8=Oop off=2227}
                                                ;*synchronization entry
                                                ; - java.util.Arrays::copyOfRange@-1 (line 3661)
                                                ;   {runtime_call}
  0x0000000110bd96d3: jmpq   0x0000000110bd8e67
  0x0000000110bd96d8: callq  0x0000000110bc72a0  ; OopMap{r8=Oop off=2237}
                                                ;*newarray
                                                ; - java.util.Arrays::copyOfRange@40 (line 3664)
                                                ;   {runtime_call}
  0x0000000110bd96dd: jmpq   0x0000000110bd8f21
  0x0000000110bd96e2: callq  0x0000000110bc6240  ; OopMap{r8=Oop rax=Oop off=2247}
                                                ;*arraylength
                                                ; - java.util.Arrays::copyOfRange@50 (line 3665)
                                                ;   {runtime_call}
  0x0000000110bd96e7: mov    %rdx,0x8(%rsp)
  0x0000000110bd96ec: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bd96f4: callq  0x0000000110bca9e0  ; OopMap{r8=Oop rax=Oop off=2265}
                                                ;*synchronization entry
                                                ; - java.lang.Math::min@-1 (line 1336)
                                                ; - java.util.Arrays::copyOfRange@54 (line 3666)
                                                ;   {runtime_call}
  0x0000000110bd96f9: jmpq   0x0000000110bd8f6c
  0x0000000110bd96fe: nop
  0x0000000110bd96ff: callq  0x0000000110b11520  ; OopMap{[112]=Oop off=2276}
                                                ;*invokestatic arraycopy
                                                ; - java.util.Arrays::copyOfRange@57 (line 3665)
                                                ;   {static_call}
  0x0000000110bd9704: jmpq   0x0000000110bd9050
  0x0000000110bd9709: movabs $0x0,%rdx          ;   {metadata(NULL)}
  0x0000000110bd9713: mov    $0xa050f00,%eax
  0x0000000110bd9718: callq  0x0000000110bc98a0  ; OopMap{off=2301}
                                                ;*new  ; - java.util.Arrays::copyOfRange@8 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd971d: jmpq   0x0000000110bd9070
  0x0000000110bd9722: mov    %rdx,%rdx
  0x0000000110bd9725: callq  0x0000000110bc69a0  ; OopMap{off=2314}
                                                ;*new  ; - java.util.Arrays::copyOfRange@8 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd972a: jmpq   0x0000000110bd90b5
  0x0000000110bd972f: movabs $0x0,%rdx          ;   {metadata(NULL)}
  0x0000000110bd9739: mov    $0xa050f00,%eax
  0x0000000110bd973e: callq  0x0000000110bc98a0  ; OopMap{rax=Oop off=2339}
                                                ;*new  ; - java.util.Arrays::copyOfRange@12 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd9743: jmpq   0x0000000110bd90b8
  0x0000000110bd9748: mov    %rdx,%rdx
  0x0000000110bd974b: callq  0x0000000110bc69a0  ; OopMap{[136]=Oop off=2352}
                                                ;*new  ; - java.util.Arrays::copyOfRange@12 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd9750: jmpq   0x0000000110bd9101
  0x0000000110bd9755: mov    %rbx,0x8(%rsp)
  0x0000000110bd975a: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bd9762: callq  0x0000000110bca9e0  ; OopMap{[136]=Oop rax=Oop off=2375}
                                                ;*synchronization entry
                                                ; - java.lang.StringBuilder::<init>@-1 (line 89)
                                                ; - java.util.Arrays::copyOfRange@16 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd9767: jmpq   0x0000000110bd9148
  0x0000000110bd976c: mov    %rbx,0x8(%rsp)
  0x0000000110bd9771: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bd9779: callq  0x0000000110bca9e0  ; OopMap{[136]=Oop rax=Oop off=2398}
                                                ;*synchronization entry
                                                ; - java.lang.AbstractStringBuilder::<init>@-1 (line 67)
                                                ; - java.lang.StringBuilder::<init>@3 (line 89)
                                                ; - java.util.Arrays::copyOfRange@16 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd977e: jmpq   0x0000000110bd918f
  0x0000000110bd9783: mov    %rbx,0x8(%rsp)
  0x0000000110bd9788: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bd9790: callq  0x0000000110bca9e0  ; OopMap{[136]=Oop rax=Oop off=2421}
                                                ;*synchronization entry
                                                ; - java.lang.Object::<init>@-1 (line 37)
                                                ; - java.lang.AbstractStringBuilder::<init>@1 (line 67)
                                                ; - java.lang.StringBuilder::<init>@3 (line 89)
                                                ; - java.util.Arrays::copyOfRange@16 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd9795: jmpq   0x0000000110bd91d6
  0x0000000110bd979a: callq  0x0000000110bc72a0  ; OopMap{[136]=Oop r13=Oop off=2431}
                                                ;*newarray
                                                ; - java.lang.AbstractStringBuilder::<init>@6 (line 68)
                                                ; - java.lang.StringBuilder::<init>@3 (line 89)
                                                ; - java.util.Arrays::copyOfRange@16 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd979f: jmpq   0x0000000110bd9255
  0x0000000110bd97a4: mov    %rdx,0x8(%rsp)
  0x0000000110bd97a9: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bd97b1: callq  0x0000000110bca9e0  ; OopMap{[136]=Oop r13=Oop off=2454}
                                                ;*synchronization entry
                                                ; - java.lang.StringBuilder::append@-1 (line 208)
                                                ; - java.util.Arrays::copyOfRange@20 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd97b6: jmpq   0x0000000110bd9337
  0x0000000110bd97bb: mov    %rdx,0x8(%rsp)
  0x0000000110bd97c0: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bd97c8: callq  0x0000000110bca9e0  ; OopMap{[120]=Oop [136]=Oop off=2477}
                                                ;*synchronization entry
                                                ; - java.lang.StringBuilder::append@-1 (line 136)
                                                ; - java.util.Arrays::copyOfRange@25 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd97cd: jmpq   0x0000000110bd9420
  0x0000000110bd97d2: mov    %rdx,0x8(%rsp)
  0x0000000110bd97d7: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bd97df: callq  0x0000000110bca9e0  ; OopMap{[120]=Oop [136]=Oop off=2500}
                                                ;*synchronization entry
                                                ; - java.lang.StringBuilder::append@-1 (line 208)
                                                ; - java.util.Arrays::copyOfRange@29 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd97e4: jmpq   0x0000000110bd9510
  0x0000000110bd97e9: mov    %rdx,0x8(%rsp)
  0x0000000110bd97ee: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bd97f6: callq  0x0000000110bca9e0  ; OopMap{[120]=Oop [136]=Oop off=2523}
                                                ;*synchronization entry
                                                ; - java.lang.StringBuilder::toString@-1 (line 407)
                                                ; - java.util.Arrays::copyOfRange@32 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd97fb: jmpq   0x0000000110bd9600
  0x0000000110bd9800: mov    %rdx,%rdx
  0x0000000110bd9803: callq  0x0000000110bc69a0  ; OopMap{[120]=Oop [136]=Oop off=2536}
                                                ;*new  ; - java.lang.StringBuilder::toString@0 (line 407)
                                                ; - java.util.Arrays::copyOfRange@32 (line 3663)
                                                ;   {runtime_call}
  0x0000000110bd9808: jmpq   0x0000000110bd9641
  0x0000000110bd980d: nop
  0x0000000110bd980e: nop
  0x0000000110bd980f: mov    0x2a8(%r15),%rax
  0x0000000110bd9816: movabs $0x0,%r10
  0x0000000110bd9820: mov    %r10,0x2a8(%r15)
  0x0000000110bd9827: movabs $0x0,%r10
  0x0000000110bd9831: mov    %r10,0x2b0(%r15)
  0x0000000110bd9838: add    $0xa0,%rsp
  0x0000000110bd983f: pop    %rbp
  0x0000000110bd9840: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bd9845: hlt    
  0x0000000110bd9846: hlt    
  0x0000000110bd9847: hlt    
  0x0000000110bd9848: hlt    
  0x0000000110bd9849: hlt    
  0x0000000110bd984a: hlt    
  0x0000000110bd984b: hlt    
  0x0000000110bd984c: hlt    
  0x0000000110bd984d: hlt    
  0x0000000110bd984e: hlt    
  0x0000000110bd984f: hlt    
  0x0000000110bd9850: hlt    
  0x0000000110bd9851: hlt    
  0x0000000110bd9852: hlt    
  0x0000000110bd9853: hlt    
  0x0000000110bd9854: hlt    
  0x0000000110bd9855: hlt    
  0x0000000110bd9856: hlt    
  0x0000000110bd9857: hlt    
  0x0000000110bd9858: hlt    
  0x0000000110bd9859: hlt    
  0x0000000110bd985a: hlt    
  0x0000000110bd985b: hlt    
  0x0000000110bd985c: hlt    
  0x0000000110bd985d: hlt    
  0x0000000110bd985e: hlt    
  0x0000000110bd985f: hlt    
[Stub Code]
  0x0000000110bd9860: nop                       ;   {no_reloc}
  0x0000000110bd9861: nop
  0x0000000110bd9862: nop
  0x0000000110bd9863: nop
  0x0000000110bd9864: nop
  0x0000000110bd9865: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bd986f: jmpq   0x0000000110bd986f  ;   {runtime_call}
  0x0000000110bd9874: nop
  0x0000000110bd9875: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bd987f: jmpq   0x0000000110bd987f  ;   {runtime_call}
  0x0000000110bd9884: nop
  0x0000000110bd9885: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bd988f: jmpq   0x0000000110bd988f  ;   {runtime_call}
  0x0000000110bd9894: nop
  0x0000000110bd9895: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bd989f: jmpq   0x0000000110bd989f  ;   {runtime_call}
  0x0000000110bd98a4: nop
  0x0000000110bd98a5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bd98af: jmpq   0x0000000110bd98af  ;   {runtime_call}
  0x0000000110bd98b4: nop
  0x0000000110bd98b5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bd98bf: jmpq   0x0000000110bd98bf  ;   {runtime_call}
[Exception Handler]
  0x0000000110bd98c4: callq  0x0000000110bc80e0  ;   {runtime_call}
  0x0000000110bd98c9: mov    %rsp,-0x28(%rsp)
  0x0000000110bd98ce: sub    $0x80,%rsp
  0x0000000110bd98d5: mov    %rax,0x78(%rsp)
  0x0000000110bd98da: mov    %rcx,0x70(%rsp)
  0x0000000110bd98df: mov    %rdx,0x68(%rsp)
  0x0000000110bd98e4: mov    %rbx,0x60(%rsp)
  0x0000000110bd98e9: mov    %rbp,0x50(%rsp)
  0x0000000110bd98ee: mov    %rsi,0x48(%rsp)
  0x0000000110bd98f3: mov    %rdi,0x40(%rsp)
  0x0000000110bd98f8: mov    %r8,0x38(%rsp)
  0x0000000110bd98fd: mov    %r9,0x30(%rsp)
  0x0000000110bd9902: mov    %r10,0x28(%rsp)
  0x0000000110bd9907: mov    %r11,0x20(%rsp)
  0x0000000110bd990c: mov    %r12,0x18(%rsp)
  0x0000000110bd9911: mov    %r13,0x10(%rsp)
  0x0000000110bd9916: mov    %r14,0x8(%rsp)
  0x0000000110bd991b: mov    %r15,(%rsp)
  0x0000000110bd991f: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bd9929: movabs $0x110bd98c9,%rsi  ;   {internal_word}
  0x0000000110bd9933: mov    %rsp,%rdx
  0x0000000110bd9936: and    $0xfffffffffffffff0,%rsp
  0x0000000110bd993a: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bd993f: hlt    
[Deopt Handler Code]
  0x0000000110bd9940: movabs $0x110bd9940,%r10  ;   {section_word}
  0x0000000110bd994a: push   %r10
  0x0000000110bd994c: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bd9951: hlt    
  0x0000000110bd9952: hlt    
  0x0000000110bd9953: hlt    
  0x0000000110bd9954: hlt    
  0x0000000110bd9955: hlt    
  0x0000000110bd9956: hlt    
  0x0000000110bd9957: hlt    
Decoding compiled method 0x0000000110bd8850:
Code:
[Entry Point]
[Verified Entry Point]
[Constants]
  # {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math'
  # parm0:    rsi       = int
  # parm1:    rdx       = int
  #           [sp+0x40]  (sp of caller)
  0x0000000110bd89c0: mov    %eax,-0x14000(%rsp)
  0x0000000110bd89c7: push   %rbp
  0x0000000110bd89c8: sub    $0x30,%rsp
  0x0000000110bd89cc: movabs $0x10dd43210,%rax  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bd89d6: mov    0xdc(%rax),%edi
  0x0000000110bd89dc: add    $0x8,%edi
  0x0000000110bd89df: mov    %edi,0xdc(%rax)
  0x0000000110bd89e5: movabs $0x10dc6cd70,%rax  ;   {metadata({method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bd89ef: and    $0x1ff8,%edi
  0x0000000110bd89f5: cmp    $0x0,%edi
  0x0000000110bd89f8: je     0x0000000110bd8a5d  ;*iload_0
                                                ; - java.lang.Math::min@0 (line 1336)

  0x0000000110bd89fe: cmp    %edx,%esi
  0x0000000110bd8a00: movabs $0x10dd43210,%rax  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bd8a0a: movabs $0x108,%rdi
  0x0000000110bd8a14: jg     0x0000000110bd8a24
  0x0000000110bd8a1a: movabs $0x118,%rdi
  0x0000000110bd8a24: mov    (%rax,%rdi,1),%rbx
  0x0000000110bd8a28: lea    0x1(%rbx),%rbx
  0x0000000110bd8a2c: mov    %rbx,(%rax,%rdi,1)
  0x0000000110bd8a30: jg     0x0000000110bd8a4b  ;*if_icmpgt
                                                ; - java.lang.Math::min@2 (line 1336)

  0x0000000110bd8a36: movabs $0x10dd43210,%rax  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bd8a40: incl   0x128(%rax)
  0x0000000110bd8a46: jmpq   0x0000000110bd8a4e  ;*goto
                                                ; - java.lang.Math::min@6 (line 1336)

  0x0000000110bd8a4b: mov    %rdx,%rsi          ;*ireturn
                                                ; - java.lang.Math::min@10 (line 1336)

  0x0000000110bd8a4e: mov    %rsi,%rax
  0x0000000110bd8a51: add    $0x30,%rsp
  0x0000000110bd8a55: pop    %rbp
  0x0000000110bd8a56: test   %eax,-0xf1e195c(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bd8a5c: retq   
  0x0000000110bd8a5d: mov    %rax,0x8(%rsp)
  0x0000000110bd8a62: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bd8a6a: callq  0x0000000110bca9e0  ; OopMap{off=175}
                                                ;*synchronization entry
                                                ; - java.lang.Math::min@-1 (line 1336)
                                                ;   {runtime_call}
  0x0000000110bd8a6f: jmp    0x0000000110bd89fe
  0x0000000110bd8a71: nop
  0x0000000110bd8a72: nop
  0x0000000110bd8a73: mov    0x2a8(%r15),%rax
  0x0000000110bd8a7a: movabs $0x0,%r10
  0x0000000110bd8a84: mov    %r10,0x2a8(%r15)
  0x0000000110bd8a8b: movabs $0x0,%r10
  0x0000000110bd8a95: mov    %r10,0x2b0(%r15)
  0x0000000110bd8a9c: add    $0x30,%rsp
  0x0000000110bd8aa0: pop    %rbp
  0x0000000110bd8aa1: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bd8aa6: hlt    
  0x0000000110bd8aa7: hlt    
  0x0000000110bd8aa8: hlt    
  0x0000000110bd8aa9: hlt    
  0x0000000110bd8aaa: hlt    
  0x0000000110bd8aab: hlt    
  0x0000000110bd8aac: hlt    
  0x0000000110bd8aad: hlt    
  0x0000000110bd8aae: hlt    
  0x0000000110bd8aaf: hlt    
  0x0000000110bd8ab0: hlt    
  0x0000000110bd8ab1: hlt    
  0x0000000110bd8ab2: hlt    
  0x0000000110bd8ab3: hlt    
  0x0000000110bd8ab4: hlt    
  0x0000000110bd8ab5: hlt    
  0x0000000110bd8ab6: hlt    
  0x0000000110bd8ab7: hlt    
  0x0000000110bd8ab8: hlt    
  0x0000000110bd8ab9: hlt    
  0x0000000110bd8aba: hlt    
  0x0000000110bd8abb: hlt    
  0x0000000110bd8abc: hlt    
  0x0000000110bd8abd: hlt    
  0x0000000110bd8abe: hlt    
  0x0000000110bd8abf: hlt    
[Exception Handler]
[Stub Code]
  0x0000000110bd8ac0: callq  0x0000000110bc80e0  ;   {no_reloc}
  0x0000000110bd8ac5: mov    %rsp,-0x28(%rsp)
  0x0000000110bd8aca: sub    $0x80,%rsp
  0x0000000110bd8ad1: mov    %rax,0x78(%rsp)
  0x0000000110bd8ad6: mov    %rcx,0x70(%rsp)
  0x0000000110bd8adb: mov    %rdx,0x68(%rsp)
  0x0000000110bd8ae0: mov    %rbx,0x60(%rsp)
  0x0000000110bd8ae5: mov    %rbp,0x50(%rsp)
  0x0000000110bd8aea: mov    %rsi,0x48(%rsp)
  0x0000000110bd8aef: mov    %rdi,0x40(%rsp)
  0x0000000110bd8af4: mov    %r8,0x38(%rsp)
  0x0000000110bd8af9: mov    %r9,0x30(%rsp)
  0x0000000110bd8afe: mov    %r10,0x28(%rsp)
  0x0000000110bd8b03: mov    %r11,0x20(%rsp)
  0x0000000110bd8b08: mov    %r12,0x18(%rsp)
  0x0000000110bd8b0d: mov    %r13,0x10(%rsp)
  0x0000000110bd8b12: mov    %r14,0x8(%rsp)
  0x0000000110bd8b17: mov    %r15,(%rsp)
  0x0000000110bd8b1b: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bd8b25: movabs $0x110bd8ac5,%rsi  ;   {internal_word}
  0x0000000110bd8b2f: mov    %rsp,%rdx
  0x0000000110bd8b32: and    $0xfffffffffffffff0,%rsp
  0x0000000110bd8b36: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bd8b3b: hlt    
[Deopt Handler Code]
  0x0000000110bd8b3c: movabs $0x110bd8b3c,%r10  ;   {section_word}
  0x0000000110bd8b46: push   %r10
  0x0000000110bd8b48: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bd8b4d: hlt    
  0x0000000110bd8b4e: hlt    
  0x0000000110bd8b4f: hlt    
Decoding compiled method 0x0000000110bdaf90:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010db7a208} 'getChars' '(II[CI)V' in 'java/lang/String'
  # this:     rsi:rsi   = 'java/lang/String'
  # parm0:    rdx       = int
  # parm1:    rcx       = int
  # parm2:    r8:r8     = '[C'
  # parm3:    r9        = int
  #           [sp+0x70]  (sp of caller)
  0x0000000110bdb140: mov    0x8(%rsi),%r10d
  0x0000000110bdb144: shl    $0x3,%r10
  0x0000000110bdb148: cmp    %rax,%r10
  0x0000000110bdb14b: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bdb151: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bdb15c: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bdb160: mov    %eax,-0x14000(%rsp)
  0x0000000110bdb167: push   %rbp
  0x0000000110bdb168: sub    $0x60,%rsp
  0x0000000110bdb16c: mov    %rdx,%rdi
  0x0000000110bdb16f: movabs $0x10dd7b6f8,%rdx  ;   {metadata(method data for {method} {0x000000010db7a208} 'getChars' '(II[CI)V' in 'java/lang/String')}
  0x0000000110bdb179: mov    0xdc(%rdx),%ebx
  0x0000000110bdb17f: add    $0x8,%ebx
  0x0000000110bdb182: mov    %ebx,0xdc(%rdx)
  0x0000000110bdb188: movabs $0x10db7a208,%rdx  ;   {metadata({method} {0x000000010db7a208} 'getChars' '(II[CI)V' in 'java/lang/String')}
  0x0000000110bdb192: and    $0x1ff8,%ebx
  0x0000000110bdb198: cmp    $0x0,%ebx
  0x0000000110bdb19b: je     0x0000000110bdb3c6  ;*iload_1
                                                ; - java.lang.String::getChars@0 (line 817)

  0x0000000110bdb1a1: cmp    $0x0,%edi
  0x0000000110bdb1a4: movabs $0x10dd7b6f8,%rdx  ;   {metadata(method data for {method} {0x000000010db7a208} 'getChars' '(II[CI)V' in 'java/lang/String')}
  0x0000000110bdb1ae: movabs $0x108,%rbx
  0x0000000110bdb1b8: jge    0x0000000110bdb1c8
  0x0000000110bdb1be: movabs $0x118,%rbx
  0x0000000110bdb1c8: mov    (%rdx,%rbx,1),%rax
  0x0000000110bdb1cc: lea    0x1(%rax),%rax
  0x0000000110bdb1d0: mov    %rax,(%rdx,%rbx,1)
  0x0000000110bdb1d4: jl     0x0000000110bdb386  ;*ifge
                                                ; - java.lang.String::getChars@1 (line 817)

  0x0000000110bdb1da: mov    0xc(%rsi),%esi
  0x0000000110bdb1dd: shl    $0x3,%rsi          ;*getfield value
                                                ; - java.lang.String::getChars@15 (line 820)

  0x0000000110bdb1e1: mov    0xc(%rsi),%edx     ;*arraylength
                                                ; - java.lang.String::getChars@18 (line 820)
                                                ; implicit exception: dispatches to 0x0000000110bdb3dd
  0x0000000110bdb1e4: cmp    %edx,%ecx
  0x0000000110bdb1e6: movabs $0x10dd7b6f8,%rdx  ;   {metadata(method data for {method} {0x000000010db7a208} 'getChars' '(II[CI)V' in 'java/lang/String')}
  0x0000000110bdb1f0: movabs $0x138,%rbx
  0x0000000110bdb1fa: jle    0x0000000110bdb20a
  0x0000000110bdb200: movabs $0x148,%rbx
  0x0000000110bdb20a: mov    (%rdx,%rbx,1),%rax
  0x0000000110bdb20e: lea    0x1(%rax),%rax
  0x0000000110bdb212: mov    %rax,(%rdx,%rbx,1)
  0x0000000110bdb216: jg     0x0000000110bdb346  ;*if_icmple
                                                ; - java.lang.String::getChars@19 (line 820)

  0x0000000110bdb21c: cmp    %ecx,%edi
  0x0000000110bdb21e: movabs $0x10dd7b6f8,%rdx  ;   {metadata(method data for {method} {0x000000010db7a208} 'getChars' '(II[CI)V' in 'java/lang/String')}
  0x0000000110bdb228: movabs $0x168,%rbx
  0x0000000110bdb232: jle    0x0000000110bdb242
  0x0000000110bdb238: movabs $0x178,%rbx
  0x0000000110bdb242: mov    (%rdx,%rbx,1),%rax
  0x0000000110bdb246: lea    0x1(%rax),%rax
  0x0000000110bdb24a: mov    %rax,(%rdx,%rbx,1)
  0x0000000110bdb24e: jg     0x0000000110bdb2fc  ;*if_icmple
                                                ; - java.lang.String::getChars@33 (line 823)

  0x0000000110bdb254: movabs $0x10dd7b6f8,%rdx  ;   {metadata(method data for {method} {0x000000010db7a208} 'getChars' '(II[CI)V' in 'java/lang/String')}
  0x0000000110bdb25e: addq   $0x1,0x198(%rdx)
  0x0000000110bdb266: mov    %rcx,%rbx
  0x0000000110bdb269: sub    %edi,%ebx
  0x0000000110bdb26b: mov    %rdi,%rdx
  0x0000000110bdb26e: mov    %r8,%rcx
  0x0000000110bdb271: mov    %r9,%r8
  0x0000000110bdb274: mov    %rbx,%r9
  0x0000000110bdb277: test   %rcx,%rcx
  0x0000000110bdb27a: je     0x0000000110bdb3e2
  0x0000000110bdb280: test   %edx,%edx
  0x0000000110bdb282: jl     0x0000000110bdb3e2
  0x0000000110bdb288: test   %r8d,%r8d
  0x0000000110bdb28b: jl     0x0000000110bdb3e2
  0x0000000110bdb291: lea    (%rdx,%r9,1),%rdi
  0x0000000110bdb295: cmp    0xc(%rsi),%edi
  0x0000000110bdb298: ja     0x0000000110bdb3e2
  0x0000000110bdb29e: lea    (%r8,%r9,1),%rdi
  0x0000000110bdb2a2: cmp    0xc(%rcx),%edi
  0x0000000110bdb2a5: ja     0x0000000110bdb3e2
  0x0000000110bdb2ab: test   %r9d,%r9d
  0x0000000110bdb2ae: jl     0x0000000110bdb3e2
  0x0000000110bdb2b4: je     0x0000000110bdb2f0
  0x0000000110bdb2ba: movslq %edx,%rdx
  0x0000000110bdb2bd: movslq %r8d,%r8
  0x0000000110bdb2c0: lea    0x10(%rsi,%rdx,2),%rdi
  0x0000000110bdb2c5: lea    0x10(%rcx,%r8,2),%rsi
  0x0000000110bdb2ca: mov    %r9,%rdx
  0x0000000110bdb2cd: test   $0xf,%esp
  0x0000000110bdb2d3: je     0x0000000110bdb2eb
  0x0000000110bdb2d9: sub    $0x8,%rsp
  0x0000000110bdb2dd: callq  Stub::jshort_arraycopy  ;   {runtime_call}
  0x0000000110bdb2e2: add    $0x8,%rsp
  0x0000000110bdb2e6: jmpq   0x0000000110bdb2f0
  0x0000000110bdb2eb: callq  Stub::jshort_arraycopy  ;*invokestatic arraycopy
                                                ; - java.lang.String::getChars@58 (line 826)
                                                ;   {runtime_call}
  0x0000000110bdb2f0: add    $0x60,%rsp
  0x0000000110bdb2f4: pop    %rbp
  0x0000000110bdb2f5: test   %eax,-0xf1e41fb(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdb2fb: retq                      ;*return
                                                ; - java.lang.String::getChars@61 (line 827)

  0x0000000110bdb2fc: nopl   0x0(%rax)
  0x0000000110bdb300: jmpq   0x0000000110bdb400  ;   {no_reloc}
  0x0000000110bdb305: add    %al,(%rax)
  0x0000000110bdb307: add    %al,(%rax)
  0x0000000110bdb309: add    %ch,%cl
  0x0000000110bdb30b: sti    
  0x0000000110bdb30c: add    %al,(%rax)
  0x0000000110bdb30e: add    %cl,-0x75(%rax)    ;*new  ; - java.lang.String::getChars@36 (line 824)

  0x0000000110bdb311: rorb   -0x42(%rax)        ;   {metadata(method data for {method} {0x000000010db7a208} 'getChars' '(II[CI)V' in 'java/lang/String')}
  0x0000000110bdb314: clc    
  0x0000000110bdb315: mov    $0xd7,%dh
  0x0000000110bdb317: or     $0x1,%eax
  0x0000000110bdb31c: addq   $0x1,0x188(%rsi)
  0x0000000110bdb324: sub    %edi,%ecx
  0x0000000110bdb326: mov    %rcx,%rdx
  0x0000000110bdb329: mov    %rax,%rsi          ;*invokespecial <init>
                                                ; - java.lang.String::getChars@43 (line 824)

  0x0000000110bdb32c: mov    %rax,0x38(%rsp)
  0x0000000110bdb331: nop
  0x0000000110bdb332: nop
  0x0000000110bdb333: nop
  0x0000000110bdb334: nop
  0x0000000110bdb335: nop
  0x0000000110bdb336: nop
  0x0000000110bdb337: callq  0x0000000110b110a0  ; OopMap{[56]=Oop off=508}
                                                ;*invokespecial <init>
                                                ; - java.lang.String::getChars@43 (line 824)
                                                ;   {optimized virtual_call}
  0x0000000110bdb33c: mov    0x38(%rsp),%rax
  0x0000000110bdb341: jmpq   0x0000000110bdb48e  ;*athrow
                                                ; - java.lang.String::getChars@46 (line 824)

  0x0000000110bdb346: xchg   %ax,%ax
  0x0000000110bdb348: jmpq   0x0000000110bdb426  ;   {no_reloc}
  0x0000000110bdb34d: add    %al,(%rax)
  0x0000000110bdb34f: add    %al,(%rax)
  0x0000000110bdb351: add    %ch,%cl
  0x0000000110bdb353: flds   (%rax)
  0x0000000110bdb355: add    %al,(%rax)         ;*new  ; - java.lang.String::getChars@22 (line 821)

  0x0000000110bdb357: mov    %rax,%rdx
  0x0000000110bdb35a: movabs $0x10dd7b6f8,%rsi  ;   {metadata(method data for {method} {0x000000010db7a208} 'getChars' '(II[CI)V' in 'java/lang/String')}
  0x0000000110bdb364: addq   $0x1,0x158(%rsi)
  0x0000000110bdb36c: mov    %rcx,%rdx
  0x0000000110bdb36f: mov    %rax,%rsi          ;*invokespecial <init>
                                                ; - java.lang.String::getChars@27 (line 821)

  0x0000000110bdb372: mov    %rax,0x40(%rsp)
  0x0000000110bdb377: callq  0x0000000110b110a0  ; OopMap{[64]=Oop off=572}
                                                ;*invokespecial <init>
                                                ; - java.lang.String::getChars@27 (line 821)
                                                ;   {optimized virtual_call}
  0x0000000110bdb37c: mov    0x40(%rsp),%rax
  0x0000000110bdb381: jmpq   0x0000000110bdb48e  ;*athrow
                                                ; - java.lang.String::getChars@30 (line 821)

  0x0000000110bdb386: xchg   %ax,%ax
  0x0000000110bdb388: jmpq   0x0000000110bdb44c  ;   {no_reloc}
  0x0000000110bdb38d: add    %al,(%rax)
  0x0000000110bdb38f: add    %al,(%rax)
  0x0000000110bdb391: add    %ch,%cl
  0x0000000110bdb393: mov    $0x48000000,%edi   ;*new  ; - java.lang.String::getChars@4 (line 818)

  0x0000000110bdb398: mov    %eax,%edx
  0x0000000110bdb39a: movabs $0x10dd7b6f8,%rsi  ;   {metadata(method data for {method} {0x000000010db7a208} 'getChars' '(II[CI)V' in 'java/lang/String')}
  0x0000000110bdb3a4: addq   $0x1,0x128(%rsi)
  0x0000000110bdb3ac: mov    %rdi,%rdx
  0x0000000110bdb3af: mov    %rax,%rsi          ;*invokespecial <init>
                                                ; - java.lang.String::getChars@9 (line 818)

  0x0000000110bdb3b2: mov    %rax,0x48(%rsp)
  0x0000000110bdb3b7: callq  0x0000000110b110a0  ; OopMap{[72]=Oop off=636}
                                                ;*invokespecial <init>
                                                ; - java.lang.String::getChars@9 (line 818)
                                                ;   {optimized virtual_call}
  0x0000000110bdb3bc: mov    0x48(%rsp),%rax
  0x0000000110bdb3c1: jmpq   0x0000000110bdb48e
  0x0000000110bdb3c6: mov    %rdx,0x8(%rsp)
  0x0000000110bdb3cb: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bdb3d3: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop r8=Oop off=664}
                                                ;*synchronization entry
                                                ; - java.lang.String::getChars@-1 (line 817)
                                                ;   {runtime_call}
  0x0000000110bdb3d8: jmpq   0x0000000110bdb1a1
  0x0000000110bdb3dd: callq  0x0000000110bc6240  ; OopMap{r8=Oop rsi=Oop off=674}
                                                ;*arraylength
                                                ; - java.lang.String::getChars@18 (line 820)
                                                ;   {runtime_call}
  0x0000000110bdb3e2: nop
  0x0000000110bdb3e3: nop
  0x0000000110bdb3e4: nop
  0x0000000110bdb3e5: nop
  0x0000000110bdb3e6: nop
  0x0000000110bdb3e7: callq  0x0000000110b11520  ; OopMap{off=684}
                                                ;*invokestatic arraycopy
                                                ; - java.lang.String::getChars@58 (line 826)
                                                ;   {static_call}
  0x0000000110bdb3ec: jmpq   0x0000000110bdb2f0
  0x0000000110bdb3f1: movabs $0x0,%rdx          ;   {metadata(NULL)}
  0x0000000110bdb3fb: mov    $0xa050f00,%eax
  0x0000000110bdb400: callq  0x0000000110bc98a0  ; OopMap{off=709}
                                                ;*new  ; - java.lang.String::getChars@36 (line 824)
                                                ;   {runtime_call}
  0x0000000110bdb405: jmpq   0x0000000110bdb300
  0x0000000110bdb40a: mov    %rdx,%rdx
  0x0000000110bdb40d: callq  0x0000000110bc66e0  ; OopMap{off=722}
                                                ;*new  ; - java.lang.String::getChars@36 (line 824)
                                                ;   {runtime_call}
  0x0000000110bdb412: jmpq   0x0000000110bdb30f
  0x0000000110bdb417: movabs $0x0,%rdx          ;   {metadata(NULL)}
  0x0000000110bdb421: mov    $0xa050f00,%eax
  0x0000000110bdb426: callq  0x0000000110bc98a0  ; OopMap{off=747}
                                                ;*new  ; - java.lang.String::getChars@22 (line 821)
                                                ;   {runtime_call}
  0x0000000110bdb42b: jmpq   0x0000000110bdb348
  0x0000000110bdb430: mov    %rdx,%rdx
  0x0000000110bdb433: callq  0x0000000110bc66e0  ; OopMap{off=760}
                                                ;*new  ; - java.lang.String::getChars@22 (line 821)
                                                ;   {runtime_call}
  0x0000000110bdb438: jmpq   0x0000000110bdb357
  0x0000000110bdb43d: movabs $0x0,%rdx          ;   {metadata(NULL)}
  0x0000000110bdb447: mov    $0xa050f00,%eax
  0x0000000110bdb44c: callq  0x0000000110bc98a0  ; OopMap{off=785}
                                                ;*new  ; - java.lang.String::getChars@4 (line 818)
                                                ;   {runtime_call}
  0x0000000110bdb451: jmpq   0x0000000110bdb388
  0x0000000110bdb456: mov    %rdx,%rdx
  0x0000000110bdb459: callq  0x0000000110bc66e0  ; OopMap{off=798}
                                                ;*new  ; - java.lang.String::getChars@4 (line 818)
                                                ;   {runtime_call}
  0x0000000110bdb45e: jmpq   0x0000000110bdb397
  0x0000000110bdb463: nop
  0x0000000110bdb464: nop
  0x0000000110bdb465: mov    0x2a8(%r15),%rax
  0x0000000110bdb46c: movabs $0x0,%r10
  0x0000000110bdb476: mov    %r10,0x2a8(%r15)
  0x0000000110bdb47d: movabs $0x0,%r10
  0x0000000110bdb487: mov    %r10,0x2b0(%r15)
  0x0000000110bdb48e: add    $0x60,%rsp
  0x0000000110bdb492: pop    %rbp
  0x0000000110bdb493: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bdb498: hlt    
  0x0000000110bdb499: hlt    
  0x0000000110bdb49a: hlt    
  0x0000000110bdb49b: hlt    
  0x0000000110bdb49c: hlt    
  0x0000000110bdb49d: hlt    
  0x0000000110bdb49e: hlt    
  0x0000000110bdb49f: hlt    
[Stub Code]
  0x0000000110bdb4a0: nop                       ;   {no_reloc}
  0x0000000110bdb4a1: nop
  0x0000000110bdb4a2: nop
  0x0000000110bdb4a3: nop
  0x0000000110bdb4a4: nop
  0x0000000110bdb4a5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bdb4af: jmpq   0x0000000110bdb4af  ;   {runtime_call}
  0x0000000110bdb4b4: nop
  0x0000000110bdb4b5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bdb4bf: jmpq   0x0000000110bdb4bf  ;   {runtime_call}
  0x0000000110bdb4c4: nop
  0x0000000110bdb4c5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bdb4cf: jmpq   0x0000000110bdb4cf  ;   {runtime_call}
  0x0000000110bdb4d4: nop
  0x0000000110bdb4d5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bdb4df: jmpq   0x0000000110bdb4df  ;   {runtime_call}
[Exception Handler]
  0x0000000110bdb4e4: callq  0x0000000110bc80e0  ;   {runtime_call}
  0x0000000110bdb4e9: mov    %rsp,-0x28(%rsp)
  0x0000000110bdb4ee: sub    $0x80,%rsp
  0x0000000110bdb4f5: mov    %rax,0x78(%rsp)
  0x0000000110bdb4fa: mov    %rcx,0x70(%rsp)
  0x0000000110bdb4ff: mov    %rdx,0x68(%rsp)
  0x0000000110bdb504: mov    %rbx,0x60(%rsp)
  0x0000000110bdb509: mov    %rbp,0x50(%rsp)
  0x0000000110bdb50e: mov    %rsi,0x48(%rsp)
  0x0000000110bdb513: mov    %rdi,0x40(%rsp)
  0x0000000110bdb518: mov    %r8,0x38(%rsp)
  0x0000000110bdb51d: mov    %r9,0x30(%rsp)
  0x0000000110bdb522: mov    %r10,0x28(%rsp)
  0x0000000110bdb527: mov    %r11,0x20(%rsp)
  0x0000000110bdb52c: mov    %r12,0x18(%rsp)
  0x0000000110bdb531: mov    %r13,0x10(%rsp)
  0x0000000110bdb536: mov    %r14,0x8(%rsp)
  0x0000000110bdb53b: mov    %r15,(%rsp)
  0x0000000110bdb53f: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bdb549: movabs $0x110bdb4e9,%rsi  ;   {internal_word}
  0x0000000110bdb553: mov    %rsp,%rdx
  0x0000000110bdb556: and    $0xfffffffffffffff0,%rsp
  0x0000000110bdb55a: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bdb55f: hlt    
[Deopt Handler Code]
  0x0000000110bdb560: movabs $0x110bdb560,%r10  ;   {section_word}
  0x0000000110bdb56a: push   %r10
  0x0000000110bdb56c: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bdb571: hlt    
  0x0000000110bdb572: hlt    
  0x0000000110bdb573: hlt    
  0x0000000110bdb574: hlt    
  0x0000000110bdb575: hlt    
  0x0000000110bdb576: hlt    
  0x0000000110bdb577: hlt    
Decoding compiled method 0x0000000110bd8590:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010db9e5b8} 'get' '()Ljava/lang/Object;' in 'java/lang/ref/Reference'
  #           [sp+0x40]  (sp of caller)
  0x0000000110bd86e0: mov    0x8(%rsi),%r10d
  0x0000000110bd86e4: shl    $0x3,%r10
  0x0000000110bd86e8: cmp    %rax,%r10
  0x0000000110bd86eb: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bd86f1: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bd86fc: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bd8700: mov    %eax,-0x14000(%rsp)
  0x0000000110bd8707: push   %rbp
  0x0000000110bd8708: sub    $0x30,%rsp
  0x0000000110bd870c: mov    0xc(%rsi),%eax
  0x0000000110bd870f: shl    $0x3,%rax          ;*aload_0
                                                ; - java.lang.ref.Reference::get@0 (line 254)

  0x0000000110bd8713: add    $0x30,%rsp
  0x0000000110bd8717: pop    %rbp
  0x0000000110bd8718: test   %eax,-0xf1e161e(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bd871e: retq   
  0x0000000110bd871f: nop
  0x0000000110bd8720: nop
  0x0000000110bd8721: mov    0x2a8(%r15),%rax
  0x0000000110bd8728: movabs $0x0,%r10
  0x0000000110bd8732: mov    %r10,0x2a8(%r15)
  0x0000000110bd8739: movabs $0x0,%r10
  0x0000000110bd8743: mov    %r10,0x2b0(%r15)
  0x0000000110bd874a: add    $0x30,%rsp
  0x0000000110bd874e: pop    %rbp
  0x0000000110bd874f: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bd8754: hlt    
  0x0000000110bd8755: hlt    
  0x0000000110bd8756: hlt    
  0x0000000110bd8757: hlt    
  0x0000000110bd8758: hlt    
  0x0000000110bd8759: hlt    
  0x0000000110bd875a: hlt    
  0x0000000110bd875b: hlt    
  0x0000000110bd875c: hlt    
  0x0000000110bd875d: hlt    
  0x0000000110bd875e: hlt    
  0x0000000110bd875f: hlt    
[Exception Handler]
[Stub Code]
  0x0000000110bd8760: callq  0x0000000110bc80e0  ;   {no_reloc}
  0x0000000110bd8765: mov    %rsp,-0x28(%rsp)
  0x0000000110bd876a: sub    $0x80,%rsp
  0x0000000110bd8771: mov    %rax,0x78(%rsp)
  0x0000000110bd8776: mov    %rcx,0x70(%rsp)
  0x0000000110bd877b: mov    %rdx,0x68(%rsp)
  0x0000000110bd8780: mov    %rbx,0x60(%rsp)
  0x0000000110bd8785: mov    %rbp,0x50(%rsp)
  0x0000000110bd878a: mov    %rsi,0x48(%rsp)
  0x0000000110bd878f: mov    %rdi,0x40(%rsp)
  0x0000000110bd8794: mov    %r8,0x38(%rsp)
  0x0000000110bd8799: mov    %r9,0x30(%rsp)
  0x0000000110bd879e: mov    %r10,0x28(%rsp)
  0x0000000110bd87a3: mov    %r11,0x20(%rsp)
  0x0000000110bd87a8: mov    %r12,0x18(%rsp)
  0x0000000110bd87ad: mov    %r13,0x10(%rsp)
  0x0000000110bd87b2: mov    %r14,0x8(%rsp)
  0x0000000110bd87b7: mov    %r15,(%rsp)
  0x0000000110bd87bb: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bd87c5: movabs $0x110bd8765,%rsi  ;   {internal_word}
  0x0000000110bd87cf: mov    %rsp,%rdx
  0x0000000110bd87d2: and    $0xfffffffffffffff0,%rsp
  0x0000000110bd87d6: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bd87db: hlt    
[Deopt Handler Code]
  0x0000000110bd87dc: movabs $0x110bd87dc,%r10  ;   {section_word}
  0x0000000110bd87e6: push   %r10
  0x0000000110bd87e8: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bd87ed: hlt    
  0x0000000110bd87ee: hlt    
  0x0000000110bd87ef: hlt    
Decoding compiled method 0x0000000110bdc090:
Code:
[Entry Point]
[Verified Entry Point]
[Constants]
  # {method} {0x000000010dd3bda0} 'of' '(I)Ljava/lang/CharacterData;' in 'java/lang/CharacterData'
  # parm0:    rsi       = int
  #           [sp+0x40]  (sp of caller)
  0x0000000110bdc240: mov    %eax,-0x14000(%rsp)
  0x0000000110bdc247: push   %rbp
  0x0000000110bdc248: sub    $0x30,%rsp
  0x0000000110bdc24c: movabs $0x10dd9f930,%rax  ;   {metadata(method data for {method} {0x000000010dd3bda0} 'of' '(I)Ljava/lang/CharacterData;' in 'java/lang/CharacterData')}
  0x0000000110bdc256: mov    0xdc(%rax),%edi
  0x0000000110bdc25c: add    $0x8,%edi
  0x0000000110bdc25f: mov    %edi,0xdc(%rax)
  0x0000000110bdc265: movabs $0x10dd3bda0,%rax  ;   {metadata({method} {0x000000010dd3bda0} 'of' '(I)Ljava/lang/CharacterData;' in 'java/lang/CharacterData')}
  0x0000000110bdc26f: and    $0x1ff8,%edi
  0x0000000110bdc275: cmp    $0x0,%edi
  0x0000000110bdc278: je     0x0000000110bdc3fc  ;*iload_0
                                                ; - java.lang.CharacterData::of@0 (line 77)

  0x0000000110bdc27e: mov    %rsi,%rax
  0x0000000110bdc281: shr    $0x8,%eax
  0x0000000110bdc284: cmp    $0x0,%eax
  0x0000000110bdc287: movabs $0x10dd9f930,%rax  ;   {metadata(method data for {method} {0x000000010dd3bda0} 'of' '(I)Ljava/lang/CharacterData;' in 'java/lang/CharacterData')}
  0x0000000110bdc291: movabs $0x108,%rdi
  0x0000000110bdc29b: jne    0x0000000110bdc2ab
  0x0000000110bdc2a1: movabs $0x118,%rdi
  0x0000000110bdc2ab: mov    (%rax,%rdi,1),%rbx
  0x0000000110bdc2af: lea    0x1(%rbx),%rbx
  0x0000000110bdc2b3: mov    %rbx,(%rax,%rdi,1)
  0x0000000110bdc2b7: je     0x0000000110bdc3e6  ;*ifne
                                                ; - java.lang.CharacterData::of@4 (line 77)

  0x0000000110bdc2bd: shr    $0x10,%esi
  0x0000000110bdc2c0: cmp    $0x0,%esi
  0x0000000110bdc2c3: je     0x0000000110bdc3be
  0x0000000110bdc2c9: cmp    $0x1,%esi
  0x0000000110bdc2cc: je     0x0000000110bdc396
  0x0000000110bdc2d2: cmp    $0x2,%esi
  0x0000000110bdc2d5: je     0x0000000110bdc36e
  0x0000000110bdc2db: cmp    $0xe,%esi
  0x0000000110bdc2de: je     0x0000000110bdc346
  0x0000000110bdc2e4: cmp    $0xf,%esi
  0x0000000110bdc2e7: je     0x0000000110bdc2f6
  0x0000000110bdc2ed: cmp    $0x10,%esi
  0x0000000110bdc2f0: jne    0x0000000110bdc31e  ;*tableswitch
                                                ; - java.lang.CharacterData::of@15 (line 80)

  0x0000000110bdc2f6: xchg   %ax,%ax
  0x0000000110bdc2f8: jmpq   0x0000000110bdc470  ;   {no_reloc}
  0x0000000110bdc2fd: add    %al,(%rax)
  0x0000000110bdc2ff: add    %al,(%rax)
  0x0000000110bdc301: add    %ah,0xf(%rsi)
  0x0000000110bdc304: (bad)  
  0x0000000110bdc305: add    %r8b,(%rax)
  0x0000000110bdc308: jmpq   0x0000000110bdc48a  ; implicit exception: dispatches to 0x0000000110bdc47a
  0x0000000110bdc30d: nop
  0x0000000110bdc30e: shl    $0x3,%rax          ;*getstatic instance
                                                ; - java.lang.CharacterData::of@112 (line 91)

  0x0000000110bdc312: add    $0x30,%rsp
  0x0000000110bdc316: pop    %rbp
  0x0000000110bdc317: test   %eax,-0xf1e521d(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdc31d: retq                      ;*areturn
                                                ; - java.lang.CharacterData::of@115 (line 91)

  0x0000000110bdc31e: xchg   %ax,%ax
  0x0000000110bdc320: jmpq   0x0000000110bdc4f1  ;   {no_reloc}
  0x0000000110bdc325: add    %al,(%rax)
  0x0000000110bdc327: add    %al,(%rax)
  0x0000000110bdc329: add    %ah,0xf(%rsi)
  0x0000000110bdc32c: (bad)  
  0x0000000110bdc32d: add    %r8b,(%rax)
  0x0000000110bdc330: jmpq   0x0000000110bdc50b  ; implicit exception: dispatches to 0x0000000110bdc4fb
  0x0000000110bdc335: nop
  0x0000000110bdc336: shl    $0x3,%rax          ;*getstatic instance
                                                ; - java.lang.CharacterData::of@116 (line 93)

  0x0000000110bdc33a: add    $0x30,%rsp
  0x0000000110bdc33e: pop    %rbp
  0x0000000110bdc33f: test   %eax,-0xf1e5245(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdc345: retq                      ;*areturn
                                                ; - java.lang.CharacterData::of@119 (line 93)

  0x0000000110bdc346: xchg   %ax,%ax
  0x0000000110bdc348: jmpq   0x0000000110bdc572  ;   {no_reloc}
  0x0000000110bdc34d: add    %al,(%rax)
  0x0000000110bdc34f: add    %al,(%rax)
  0x0000000110bdc351: add    %ah,0xf(%rsi)
  0x0000000110bdc354: (bad)  
  0x0000000110bdc355: add    %r8b,(%rax)
  0x0000000110bdc358: jmpq   0x0000000110bdc58c  ; implicit exception: dispatches to 0x0000000110bdc57c
  0x0000000110bdc35d: nop
  0x0000000110bdc35e: shl    $0x3,%rax          ;*getstatic instance
                                                ; - java.lang.CharacterData::of@108 (line 88)

  0x0000000110bdc362: add    $0x30,%rsp
  0x0000000110bdc366: pop    %rbp
  0x0000000110bdc367: test   %eax,-0xf1e526d(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdc36d: retq                      ;*areturn
                                                ; - java.lang.CharacterData::of@111 (line 88)

  0x0000000110bdc36e: xchg   %ax,%ax
  0x0000000110bdc370: jmpq   0x0000000110bdc5f3  ;   {no_reloc}
  0x0000000110bdc375: add    %al,(%rax)
  0x0000000110bdc377: add    %al,(%rax)
  0x0000000110bdc379: add    %ah,0xf(%rsi)
  0x0000000110bdc37c: (bad)  
  0x0000000110bdc37d: add    %r8b,(%rax)
  0x0000000110bdc380: jmpq   0x0000000110bdc60d  ; implicit exception: dispatches to 0x0000000110bdc5fd
  0x0000000110bdc385: nop
  0x0000000110bdc386: shl    $0x3,%rax          ;*getstatic instance
                                                ; - java.lang.CharacterData::of@104 (line 86)

  0x0000000110bdc38a: add    $0x30,%rsp
  0x0000000110bdc38e: pop    %rbp
  0x0000000110bdc38f: test   %eax,-0xf1e5295(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdc395: retq                      ;*areturn
                                                ; - java.lang.CharacterData::of@107 (line 86)

  0x0000000110bdc396: xchg   %ax,%ax
  0x0000000110bdc398: jmpq   0x0000000110bdc674  ;   {no_reloc}
  0x0000000110bdc39d: add    %al,(%rax)
  0x0000000110bdc39f: add    %al,(%rax)
  0x0000000110bdc3a1: add    %ah,0xf(%rsi)
  0x0000000110bdc3a4: (bad)  
  0x0000000110bdc3a5: add    %r8b,(%rax)
  0x0000000110bdc3a8: jmpq   0x0000000110bdc68e  ; implicit exception: dispatches to 0x0000000110bdc67e
  0x0000000110bdc3ad: nop
  0x0000000110bdc3ae: shl    $0x3,%rax          ;*getstatic instance
                                                ; - java.lang.CharacterData::of@100 (line 84)

  0x0000000110bdc3b2: add    $0x30,%rsp
  0x0000000110bdc3b6: pop    %rbp
  0x0000000110bdc3b7: test   %eax,-0xf1e52bd(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdc3bd: retq                      ;*areturn
                                                ; - java.lang.CharacterData::of@103 (line 84)

  0x0000000110bdc3be: xchg   %ax,%ax
  0x0000000110bdc3c0: jmpq   0x0000000110bdc6f5  ;   {no_reloc}
  0x0000000110bdc3c5: add    %al,(%rax)
  0x0000000110bdc3c7: add    %al,(%rax)
  0x0000000110bdc3c9: add    %ah,0xf(%rsi)
  0x0000000110bdc3cc: (bad)  
  0x0000000110bdc3cd: add    %r8b,(%rax)
  0x0000000110bdc3d0: jmpq   0x0000000110bdc70f  ; implicit exception: dispatches to 0x0000000110bdc6ff
  0x0000000110bdc3d5: nop
  0x0000000110bdc3d6: shl    $0x3,%rax          ;*getstatic instance
                                                ; - java.lang.CharacterData::of@96 (line 82)

  0x0000000110bdc3da: add    $0x30,%rsp
  0x0000000110bdc3de: pop    %rbp
  0x0000000110bdc3df: test   %eax,-0xf1e52e5(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdc3e5: retq                      ;*areturn
                                                ; - java.lang.CharacterData::of@99 (line 82)

  0x0000000110bdc3e6: movabs $0x76ab47238,%rax  ;   {oop(a 'java/lang/CharacterDataLatin1')}
  0x0000000110bdc3f0: add    $0x30,%rsp
  0x0000000110bdc3f4: pop    %rbp
  0x0000000110bdc3f5: test   %eax,-0xf1e52fb(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdc3fb: retq   
  0x0000000110bdc3fc: mov    %rax,0x8(%rsp)
  0x0000000110bdc401: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bdc409: callq  0x0000000110bca9e0  ; OopMap{off=462}
                                                ;*synchronization entry
                                                ; - java.lang.CharacterData::of@-1 (line 77)
                                                ;   {runtime_call}
  0x0000000110bdc40e: jmpq   0x0000000110bdc27e
  0x0000000110bdc413: movabs $0x0,%rax          ;   {oop(NULL)}
  0x0000000110bdc41d: push   %rax
  0x0000000110bdc41e: push   %rbx
  0x0000000110bdc41f: mov    0x48(%rax),%rbx
  0x0000000110bdc423: push   %rdi
  0x0000000110bdc424: push   %rsi
  0x0000000110bdc425: push   %rdx
  0x0000000110bdc426: push   %rcx
  0x0000000110bdc427: push   %r8
  0x0000000110bdc429: push   %r9
  0x0000000110bdc42b: push   %r10
  0x0000000110bdc42d: mov    %rsp,%r10
  0x0000000110bdc430: and    $0xfffffffffffffff0,%rsp
  0x0000000110bdc434: push   %r10
  0x0000000110bdc436: push   %r11
  0x0000000110bdc438: mov    $0x10c,%edi
  0x0000000110bdc43d: movabs $0x7fff68eebbf5,%r10  ;   {runtime_call}
  0x0000000110bdc447: callq  *%r10
  0x0000000110bdc44a: pop    %r11
  0x0000000110bdc44c: pop    %rsp
  0x0000000110bdc44d: pop    %r10
  0x0000000110bdc44f: pop    %r9
  0x0000000110bdc451: pop    %r8
  0x0000000110bdc453: pop    %rcx
  0x0000000110bdc454: pop    %rdx
  0x0000000110bdc455: pop    %rsi
  0x0000000110bdc456: pop    %rdi
  0x0000000110bdc457: cmp    0x118(%rbx),%rax
  0x0000000110bdc45e: pop    %rbx
  0x0000000110bdc45f: pop    %rax
  0x0000000110bdc460: jne    0x0000000110bdc470
  0x0000000110bdc466: jmpq   0x0000000110bdc302
  0x0000000110bdc46b: mov    $0xa535d00,%eax
  0x0000000110bdc470: callq  0x0000000110bc9ca0  ; OopMap{off=565}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@112 (line 91)
                                                ;   {runtime_call}
  0x0000000110bdc475: jmpq   0x0000000110bdc2f8
  0x0000000110bdc47a: callq  0x0000000110bc6240  ; OopMap{rax=Oop off=575}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@112 (line 91)
                                                ;   {runtime_call}
  0x0000000110bdc47f: mov    0x0(%rax),%eax
  0x0000000110bdc485: mov    $0x6050b00,%eax
  0x0000000110bdc48a: callq  0x0000000110bc94a0  ; OopMap{rax=Oop off=591}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@112 (line 91)
                                                ;   {runtime_call}
  0x0000000110bdc48f: jmpq   0x0000000110bdc308
  0x0000000110bdc494: movabs $0x0,%rax          ;   {oop(NULL)}
  0x0000000110bdc49e: push   %rax
  0x0000000110bdc49f: push   %rbx
  0x0000000110bdc4a0: mov    0x48(%rax),%rbx
  0x0000000110bdc4a4: push   %rdi
  0x0000000110bdc4a5: push   %rsi
  0x0000000110bdc4a6: push   %rdx
  0x0000000110bdc4a7: push   %rcx
  0x0000000110bdc4a8: push   %r8
  0x0000000110bdc4aa: push   %r9
  0x0000000110bdc4ac: push   %r10
  0x0000000110bdc4ae: mov    %rsp,%r10
  0x0000000110bdc4b1: and    $0xfffffffffffffff0,%rsp
  0x0000000110bdc4b5: push   %r10
  0x0000000110bdc4b7: push   %r11
  0x0000000110bdc4b9: mov    $0x10c,%edi
  0x0000000110bdc4be: movabs $0x7fff68eebbf5,%r10  ;   {runtime_call}
  0x0000000110bdc4c8: callq  *%r10
  0x0000000110bdc4cb: pop    %r11
  0x0000000110bdc4cd: pop    %rsp
  0x0000000110bdc4ce: pop    %r10
  0x0000000110bdc4d0: pop    %r9
  0x0000000110bdc4d2: pop    %r8
  0x0000000110bdc4d4: pop    %rcx
  0x0000000110bdc4d5: pop    %rdx
  0x0000000110bdc4d6: pop    %rsi
  0x0000000110bdc4d7: pop    %rdi
  0x0000000110bdc4d8: cmp    0x118(%rbx),%rax
  0x0000000110bdc4df: pop    %rbx
  0x0000000110bdc4e0: pop    %rax
  0x0000000110bdc4e1: jne    0x0000000110bdc4f1
  0x0000000110bdc4e7: jmpq   0x0000000110bdc32a
  0x0000000110bdc4ec: mov    $0xa535d00,%eax
  0x0000000110bdc4f1: callq  0x0000000110bc9ca0  ; OopMap{off=694}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@116 (line 93)
                                                ;   {runtime_call}
  0x0000000110bdc4f6: jmpq   0x0000000110bdc320
  0x0000000110bdc4fb: callq  0x0000000110bc6240  ; OopMap{rax=Oop off=704}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@116 (line 93)
                                                ;   {runtime_call}
  0x0000000110bdc500: mov    0x0(%rax),%eax
  0x0000000110bdc506: mov    $0x6050b00,%eax
  0x0000000110bdc50b: callq  0x0000000110bc94a0  ; OopMap{rax=Oop off=720}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@116 (line 93)
                                                ;   {runtime_call}
  0x0000000110bdc510: jmpq   0x0000000110bdc330
  0x0000000110bdc515: movabs $0x0,%rax          ;   {oop(NULL)}
  0x0000000110bdc51f: push   %rax
  0x0000000110bdc520: push   %rbx
  0x0000000110bdc521: mov    0x48(%rax),%rbx
  0x0000000110bdc525: push   %rdi
  0x0000000110bdc526: push   %rsi
  0x0000000110bdc527: push   %rdx
  0x0000000110bdc528: push   %rcx
  0x0000000110bdc529: push   %r8
  0x0000000110bdc52b: push   %r9
  0x0000000110bdc52d: push   %r10
  0x0000000110bdc52f: mov    %rsp,%r10
  0x0000000110bdc532: and    $0xfffffffffffffff0,%rsp
  0x0000000110bdc536: push   %r10
  0x0000000110bdc538: push   %r11
  0x0000000110bdc53a: mov    $0x10c,%edi
  0x0000000110bdc53f: movabs $0x7fff68eebbf5,%r10  ;   {runtime_call}
  0x0000000110bdc549: callq  *%r10
  0x0000000110bdc54c: pop    %r11
  0x0000000110bdc54e: pop    %rsp
  0x0000000110bdc54f: pop    %r10
  0x0000000110bdc551: pop    %r9
  0x0000000110bdc553: pop    %r8
  0x0000000110bdc555: pop    %rcx
  0x0000000110bdc556: pop    %rdx
  0x0000000110bdc557: pop    %rsi
  0x0000000110bdc558: pop    %rdi
  0x0000000110bdc559: cmp    0x118(%rbx),%rax
  0x0000000110bdc560: pop    %rbx
  0x0000000110bdc561: pop    %rax
  0x0000000110bdc562: jne    0x0000000110bdc572
  0x0000000110bdc568: jmpq   0x0000000110bdc352
  0x0000000110bdc56d: mov    $0xa535d00,%eax
  0x0000000110bdc572: callq  0x0000000110bc9ca0  ; OopMap{off=823}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@108 (line 88)
                                                ;   {runtime_call}
  0x0000000110bdc577: jmpq   0x0000000110bdc348
  0x0000000110bdc57c: callq  0x0000000110bc6240  ; OopMap{rax=Oop off=833}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@108 (line 88)
                                                ;   {runtime_call}
  0x0000000110bdc581: mov    0x0(%rax),%eax
  0x0000000110bdc587: mov    $0x6050b00,%eax
  0x0000000110bdc58c: callq  0x0000000110bc94a0  ; OopMap{rax=Oop off=849}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@108 (line 88)
                                                ;   {runtime_call}
  0x0000000110bdc591: jmpq   0x0000000110bdc358
  0x0000000110bdc596: movabs $0x0,%rax          ;   {oop(NULL)}
  0x0000000110bdc5a0: push   %rax
  0x0000000110bdc5a1: push   %rbx
  0x0000000110bdc5a2: mov    0x48(%rax),%rbx
  0x0000000110bdc5a6: push   %rdi
  0x0000000110bdc5a7: push   %rsi
  0x0000000110bdc5a8: push   %rdx
  0x0000000110bdc5a9: push   %rcx
  0x0000000110bdc5aa: push   %r8
  0x0000000110bdc5ac: push   %r9
  0x0000000110bdc5ae: push   %r10
  0x0000000110bdc5b0: mov    %rsp,%r10
  0x0000000110bdc5b3: and    $0xfffffffffffffff0,%rsp
  0x0000000110bdc5b7: push   %r10
  0x0000000110bdc5b9: push   %r11
  0x0000000110bdc5bb: mov    $0x10c,%edi
  0x0000000110bdc5c0: movabs $0x7fff68eebbf5,%r10  ;   {runtime_call}
  0x0000000110bdc5ca: callq  *%r10
  0x0000000110bdc5cd: pop    %r11
  0x0000000110bdc5cf: pop    %rsp
  0x0000000110bdc5d0: pop    %r10
  0x0000000110bdc5d2: pop    %r9
  0x0000000110bdc5d4: pop    %r8
  0x0000000110bdc5d6: pop    %rcx
  0x0000000110bdc5d7: pop    %rdx
  0x0000000110bdc5d8: pop    %rsi
  0x0000000110bdc5d9: pop    %rdi
  0x0000000110bdc5da: cmp    0x118(%rbx),%rax
  0x0000000110bdc5e1: pop    %rbx
  0x0000000110bdc5e2: pop    %rax
  0x0000000110bdc5e3: jne    0x0000000110bdc5f3
  0x0000000110bdc5e9: jmpq   0x0000000110bdc37a
  0x0000000110bdc5ee: mov    $0xa535d00,%eax
  0x0000000110bdc5f3: callq  0x0000000110bc9ca0  ; OopMap{off=952}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@104 (line 86)
                                                ;   {runtime_call}
  0x0000000110bdc5f8: jmpq   0x0000000110bdc370
  0x0000000110bdc5fd: callq  0x0000000110bc6240  ; OopMap{rax=Oop off=962}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@104 (line 86)
                                                ;   {runtime_call}
  0x0000000110bdc602: mov    0x0(%rax),%eax
  0x0000000110bdc608: mov    $0x6050b00,%eax
  0x0000000110bdc60d: callq  0x0000000110bc94a0  ; OopMap{rax=Oop off=978}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@104 (line 86)
                                                ;   {runtime_call}
  0x0000000110bdc612: jmpq   0x0000000110bdc380
  0x0000000110bdc617: movabs $0x0,%rax          ;   {oop(NULL)}
  0x0000000110bdc621: push   %rax
  0x0000000110bdc622: push   %rbx
  0x0000000110bdc623: mov    0x48(%rax),%rbx
  0x0000000110bdc627: push   %rdi
  0x0000000110bdc628: push   %rsi
  0x0000000110bdc629: push   %rdx
  0x0000000110bdc62a: push   %rcx
  0x0000000110bdc62b: push   %r8
  0x0000000110bdc62d: push   %r9
  0x0000000110bdc62f: push   %r10
  0x0000000110bdc631: mov    %rsp,%r10
  0x0000000110bdc634: and    $0xfffffffffffffff0,%rsp
  0x0000000110bdc638: push   %r10
  0x0000000110bdc63a: push   %r11
  0x0000000110bdc63c: mov    $0x10c,%edi
  0x0000000110bdc641: movabs $0x7fff68eebbf5,%r10  ;   {runtime_call}
  0x0000000110bdc64b: callq  *%r10
  0x0000000110bdc64e: pop    %r11
  0x0000000110bdc650: pop    %rsp
  0x0000000110bdc651: pop    %r10
  0x0000000110bdc653: pop    %r9
  0x0000000110bdc655: pop    %r8
  0x0000000110bdc657: pop    %rcx
  0x0000000110bdc658: pop    %rdx
  0x0000000110bdc659: pop    %rsi
  0x0000000110bdc65a: pop    %rdi
  0x0000000110bdc65b: cmp    0x118(%rbx),%rax
  0x0000000110bdc662: pop    %rbx
  0x0000000110bdc663: pop    %rax
  0x0000000110bdc664: jne    0x0000000110bdc674
  0x0000000110bdc66a: jmpq   0x0000000110bdc3a2
  0x0000000110bdc66f: mov    $0xa535d00,%eax
  0x0000000110bdc674: callq  0x0000000110bc9ca0  ; OopMap{off=1081}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@100 (line 84)
                                                ;   {runtime_call}
  0x0000000110bdc679: jmpq   0x0000000110bdc398
  0x0000000110bdc67e: callq  0x0000000110bc6240  ; OopMap{rax=Oop off=1091}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@100 (line 84)
                                                ;   {runtime_call}
  0x0000000110bdc683: mov    0x0(%rax),%eax
  0x0000000110bdc689: mov    $0x6050b00,%eax
  0x0000000110bdc68e: callq  0x0000000110bc94a0  ; OopMap{rax=Oop off=1107}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@100 (line 84)
                                                ;   {runtime_call}
  0x0000000110bdc693: jmpq   0x0000000110bdc3a8
  0x0000000110bdc698: movabs $0x0,%rax          ;   {oop(NULL)}
  0x0000000110bdc6a2: push   %rax
  0x0000000110bdc6a3: push   %rbx
  0x0000000110bdc6a4: mov    0x48(%rax),%rbx
  0x0000000110bdc6a8: push   %rdi
  0x0000000110bdc6a9: push   %rsi
  0x0000000110bdc6aa: push   %rdx
  0x0000000110bdc6ab: push   %rcx
  0x0000000110bdc6ac: push   %r8
  0x0000000110bdc6ae: push   %r9
  0x0000000110bdc6b0: push   %r10
  0x0000000110bdc6b2: mov    %rsp,%r10
  0x0000000110bdc6b5: and    $0xfffffffffffffff0,%rsp
  0x0000000110bdc6b9: push   %r10
  0x0000000110bdc6bb: push   %r11
  0x0000000110bdc6bd: mov    $0x10c,%edi
  0x0000000110bdc6c2: movabs $0x7fff68eebbf5,%r10  ;   {runtime_call}
  0x0000000110bdc6cc: callq  *%r10
  0x0000000110bdc6cf: pop    %r11
  0x0000000110bdc6d1: pop    %rsp
  0x0000000110bdc6d2: pop    %r10
  0x0000000110bdc6d4: pop    %r9
  0x0000000110bdc6d6: pop    %r8
  0x0000000110bdc6d8: pop    %rcx
  0x0000000110bdc6d9: pop    %rdx
  0x0000000110bdc6da: pop    %rsi
  0x0000000110bdc6db: pop    %rdi
  0x0000000110bdc6dc: cmp    0x118(%rbx),%rax
  0x0000000110bdc6e3: pop    %rbx
  0x0000000110bdc6e4: pop    %rax
  0x0000000110bdc6e5: jne    0x0000000110bdc6f5
  0x0000000110bdc6eb: jmpq   0x0000000110bdc3ca
  0x0000000110bdc6f0: mov    $0xa535d00,%eax
  0x0000000110bdc6f5: callq  0x0000000110bc9ca0  ; OopMap{off=1210}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@96 (line 82)
                                                ;   {runtime_call}
  0x0000000110bdc6fa: jmpq   0x0000000110bdc3c0
  0x0000000110bdc6ff: callq  0x0000000110bc6240  ; OopMap{rax=Oop off=1220}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@96 (line 82)
                                                ;   {runtime_call}
  0x0000000110bdc704: mov    0x0(%rax),%eax
  0x0000000110bdc70a: mov    $0x6050b00,%eax
  0x0000000110bdc70f: callq  0x0000000110bc94a0  ; OopMap{rax=Oop off=1236}
                                                ;*getstatic instance
                                                ; - java.lang.CharacterData::of@96 (line 82)
                                                ;   {runtime_call}
  0x0000000110bdc714: jmpq   0x0000000110bdc3d0
  0x0000000110bdc719: nop
  0x0000000110bdc71a: nop
  0x0000000110bdc71b: mov    0x2a8(%r15),%rax
  0x0000000110bdc722: movabs $0x0,%r10
  0x0000000110bdc72c: mov    %r10,0x2a8(%r15)
  0x0000000110bdc733: movabs $0x0,%r10
  0x0000000110bdc73d: mov    %r10,0x2b0(%r15)
  0x0000000110bdc744: add    $0x30,%rsp
  0x0000000110bdc748: pop    %rbp
  0x0000000110bdc749: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bdc74e: hlt    
  0x0000000110bdc74f: hlt    
  0x0000000110bdc750: hlt    
  0x0000000110bdc751: hlt    
  0x0000000110bdc752: hlt    
  0x0000000110bdc753: hlt    
  0x0000000110bdc754: hlt    
  0x0000000110bdc755: hlt    
  0x0000000110bdc756: hlt    
  0x0000000110bdc757: hlt    
  0x0000000110bdc758: hlt    
  0x0000000110bdc759: hlt    
  0x0000000110bdc75a: hlt    
  0x0000000110bdc75b: hlt    
  0x0000000110bdc75c: hlt    
  0x0000000110bdc75d: hlt    
  0x0000000110bdc75e: hlt    
  0x0000000110bdc75f: hlt    
[Exception Handler]
[Stub Code]
  0x0000000110bdc760: callq  0x0000000110bc80e0  ;   {no_reloc}
  0x0000000110bdc765: mov    %rsp,-0x28(%rsp)
  0x0000000110bdc76a: sub    $0x80,%rsp
  0x0000000110bdc771: mov    %rax,0x78(%rsp)
  0x0000000110bdc776: mov    %rcx,0x70(%rsp)
  0x0000000110bdc77b: mov    %rdx,0x68(%rsp)
  0x0000000110bdc780: mov    %rbx,0x60(%rsp)
  0x0000000110bdc785: mov    %rbp,0x50(%rsp)
  0x0000000110bdc78a: mov    %rsi,0x48(%rsp)
  0x0000000110bdc78f: mov    %rdi,0x40(%rsp)
  0x0000000110bdc794: mov    %r8,0x38(%rsp)
  0x0000000110bdc799: mov    %r9,0x30(%rsp)
  0x0000000110bdc79e: mov    %r10,0x28(%rsp)
  0x0000000110bdc7a3: mov    %r11,0x20(%rsp)
  0x0000000110bdc7a8: mov    %r12,0x18(%rsp)
  0x0000000110bdc7ad: mov    %r13,0x10(%rsp)
  0x0000000110bdc7b2: mov    %r14,0x8(%rsp)
  0x0000000110bdc7b7: mov    %r15,(%rsp)
  0x0000000110bdc7bb: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bdc7c5: movabs $0x110bdc765,%rsi  ;   {internal_word}
  0x0000000110bdc7cf: mov    %rsp,%rdx
  0x0000000110bdc7d2: and    $0xfffffffffffffff0,%rsp
  0x0000000110bdc7d6: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bdc7db: hlt    
[Deopt Handler Code]
  0x0000000110bdc7dc: movabs $0x110bdc7dc,%r10  ;   {section_word}
  0x0000000110bdc7e6: push   %r10
  0x0000000110bdc7e8: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bdc7ed: hlt    
  0x0000000110bdc7ee: hlt    
  0x0000000110bdc7ef: hlt    
Decoding compiled method 0x0000000110bdcb50:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010dd3c478} 'getProperties' '(I)I' in 'java/lang/CharacterDataLatin1'
  # this:     rsi:rsi   = 'java/lang/CharacterDataLatin1'
  # parm0:    rdx       = int
  #           [sp+0x40]  (sp of caller)
  0x0000000110bdccc0: mov    0x8(%rsi),%r10d
  0x0000000110bdccc4: shl    $0x3,%r10
  0x0000000110bdccc8: cmp    %rax,%r10
  0x0000000110bdcccb: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bdccd1: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bdccdc: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bdcce0: mov    %eax,-0x14000(%rsp)
  0x0000000110bdcce7: push   %rbp
  0x0000000110bdcce8: sub    $0x30,%rsp
  0x0000000110bdccec: movabs $0x10dda2090,%rax  ;   {metadata(method data for {method} {0x000000010dd3c478} 'getProperties' '(I)I' in 'java/lang/CharacterDataLatin1')}
  0x0000000110bdccf6: mov    0xdc(%rax),%edi
  0x0000000110bdccfc: add    $0x8,%edi
  0x0000000110bdccff: mov    %edi,0xdc(%rax)
  0x0000000110bdcd05: movabs $0x10dd3c478,%rax  ;   {metadata({method} {0x000000010dd3c478} 'getProperties' '(I)I' in 'java/lang/CharacterDataLatin1')}
  0x0000000110bdcd0f: and    $0x1ff8,%edi
  0x0000000110bdcd15: cmp    $0x0,%edi
  0x0000000110bdcd18: je     0x0000000110bdcd4a  ;*iload_1
                                                ; - java.lang.CharacterDataLatin1::getProperties@0 (line 71)

  0x0000000110bdcd1e: and    $0xffff,%edx
  0x0000000110bdcd24: movabs $0x76ab47248,%rax  ;   {oop([I)}
  0x0000000110bdcd2e: movslq %edx,%rsi
  0x0000000110bdcd31: cmp    0xc(%rax),%edx     ; implicit exception: dispatches to 0x0000000110bdcd5e
  0x0000000110bdcd34: jae    0x0000000110bdcd68
  0x0000000110bdcd3a: mov    0x10(%rax,%rsi,4),%eax  ;*iaload
                                                ; - java.lang.CharacterDataLatin1::getProperties@7 (line 72)

  0x0000000110bdcd3e: add    $0x30,%rsp
  0x0000000110bdcd42: pop    %rbp
  0x0000000110bdcd43: test   %eax,-0xf1e5c49(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdcd49: retq   
  0x0000000110bdcd4a: mov    %rax,0x8(%rsp)
  0x0000000110bdcd4f: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bdcd57: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop off=156}
                                                ;*synchronization entry
                                                ; - java.lang.CharacterDataLatin1::getProperties@-1 (line 71)
                                                ;   {runtime_call}
  0x0000000110bdcd5c: jmp    0x0000000110bdcd1e
  0x0000000110bdcd5e: callq  0x0000000110bc6240  ; OopMap{rax=Oop off=163}
                                                ;*iaload
                                                ; - java.lang.CharacterDataLatin1::getProperties@7 (line 72)
                                                ;   {runtime_call}
  0x0000000110bdcd63: callq  0x0000000110bc6240  ; OopMap{rax=Oop off=168}
                                                ;*iaload
                                                ; - java.lang.CharacterDataLatin1::getProperties@7 (line 72)
                                                ;   {runtime_call}
  0x0000000110bdcd68: mov    %rdx,(%rsp)
  0x0000000110bdcd6c: callq  0x0000000110b38800  ; OopMap{rax=Oop off=177}
                                                ;*iaload
                                                ; - java.lang.CharacterDataLatin1::getProperties@7 (line 72)
                                                ;   {runtime_call}
  0x0000000110bdcd71: nop
  0x0000000110bdcd72: nop
  0x0000000110bdcd73: mov    0x2a8(%r15),%rax
  0x0000000110bdcd7a: movabs $0x0,%r10
  0x0000000110bdcd84: mov    %r10,0x2a8(%r15)
  0x0000000110bdcd8b: movabs $0x0,%r10
  0x0000000110bdcd95: mov    %r10,0x2b0(%r15)
  0x0000000110bdcd9c: add    $0x30,%rsp
  0x0000000110bdcda0: pop    %rbp
  0x0000000110bdcda1: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bdcda6: hlt    
  0x0000000110bdcda7: hlt    
  0x0000000110bdcda8: hlt    
  0x0000000110bdcda9: hlt    
  0x0000000110bdcdaa: hlt    
  0x0000000110bdcdab: hlt    
  0x0000000110bdcdac: hlt    
  0x0000000110bdcdad: hlt    
  0x0000000110bdcdae: hlt    
  0x0000000110bdcdaf: hlt    
  0x0000000110bdcdb0: hlt    
  0x0000000110bdcdb1: hlt    
  0x0000000110bdcdb2: hlt    
  0x0000000110bdcdb3: hlt    
  0x0000000110bdcdb4: hlt    
  0x0000000110bdcdb5: hlt    
  0x0000000110bdcdb6: hlt    
  0x0000000110bdcdb7: hlt    
  0x0000000110bdcdb8: hlt    
  0x0000000110bdcdb9: hlt    
  0x0000000110bdcdba: hlt    
  0x0000000110bdcdbb: hlt    
  0x0000000110bdcdbc: hlt    
  0x0000000110bdcdbd: hlt    
  0x0000000110bdcdbe: hlt    
  0x0000000110bdcdbf: hlt    
[Exception Handler]
[Stub Code]
  0x0000000110bdcdc0: callq  0x0000000110bc80e0  ;   {no_reloc}
  0x0000000110bdcdc5: mov    %rsp,-0x28(%rsp)
  0x0000000110bdcdca: sub    $0x80,%rsp
  0x0000000110bdcdd1: mov    %rax,0x78(%rsp)
  0x0000000110bdcdd6: mov    %rcx,0x70(%rsp)
  0x0000000110bdcddb: mov    %rdx,0x68(%rsp)
  0x0000000110bdcde0: mov    %rbx,0x60(%rsp)
  0x0000000110bdcde5: mov    %rbp,0x50(%rsp)
  0x0000000110bdcdea: mov    %rsi,0x48(%rsp)
  0x0000000110bdcdef: mov    %rdi,0x40(%rsp)
  0x0000000110bdcdf4: mov    %r8,0x38(%rsp)
  0x0000000110bdcdf9: mov    %r9,0x30(%rsp)
  0x0000000110bdcdfe: mov    %r10,0x28(%rsp)
  0x0000000110bdce03: mov    %r11,0x20(%rsp)
  0x0000000110bdce08: mov    %r12,0x18(%rsp)
  0x0000000110bdce0d: mov    %r13,0x10(%rsp)
  0x0000000110bdce12: mov    %r14,0x8(%rsp)
  0x0000000110bdce17: mov    %r15,(%rsp)
  0x0000000110bdce1b: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bdce25: movabs $0x110bdcdc5,%rsi  ;   {internal_word}
  0x0000000110bdce2f: mov    %rsp,%rdx
  0x0000000110bdce32: and    $0xfffffffffffffff0,%rsp
  0x0000000110bdce36: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bdce3b: hlt    
[Deopt Handler Code]
  0x0000000110bdce3c: movabs $0x110bdce3c,%r10  ;   {section_word}
  0x0000000110bdce46: push   %r10
  0x0000000110bdce48: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bdce4d: hlt    
  0x0000000110bdce4e: hlt    
  0x0000000110bdce4f: hlt    
Decoding compiled method 0x0000000110bdcf50:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010dbebf68} 'append' '(Ljava/lang/String;)Ljava/lang/AbstractStringBuilder;' in 'java/lang/AbstractStringBuilder'
  # this:     rsi:rsi   = 'java/lang/AbstractStringBuilder'
  # parm0:    rdx:rdx   = 'java/lang/String'
  #           [sp+0xf0]  (sp of caller)
  0x0000000110bdd120: mov    0x8(%rsi),%r10d
  0x0000000110bdd124: shl    $0x3,%r10
  0x0000000110bdd128: cmp    %rax,%r10
  0x0000000110bdd12b: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bdd131: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bdd13c: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bdd140: mov    %eax,-0x14000(%rsp)
  0x0000000110bdd147: push   %rbp
  0x0000000110bdd148: sub    $0xe0,%rsp
  0x0000000110bdd14f: mov    %rsi,0xb8(%rsp)
  0x0000000110bdd157: movabs $0x10dd78c90,%rdi  ;   {metadata(method data for {method} {0x000000010dbebf68} 'append' '(Ljava/lang/String;)Ljava/lang/AbstractStringBuilder;' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd161: mov    0xdc(%rdi),%ebx
  0x0000000110bdd167: add    $0x8,%ebx
  0x0000000110bdd16a: mov    %ebx,0xdc(%rdi)
  0x0000000110bdd170: movabs $0x10dbebf68,%rdi  ;   {metadata({method} {0x000000010dbebf68} 'append' '(Ljava/lang/String;)Ljava/lang/AbstractStringBuilder;' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd17a: and    $0x1ff8,%ebx
  0x0000000110bdd180: cmp    $0x0,%ebx
  0x0000000110bdd183: je     0x0000000110bdd6b3  ;*aload_1
                                                ; - java.lang.AbstractStringBuilder::append@0 (line 445)

  0x0000000110bdd189: cmp    $0x0,%rdx
  0x0000000110bdd18d: movabs $0x10dd78c90,%rdi  ;   {metadata(method data for {method} {0x000000010dbebf68} 'append' '(Ljava/lang/String;)Ljava/lang/AbstractStringBuilder;' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd197: movabs $0x108,%rbx
  0x0000000110bdd1a1: jne    0x0000000110bdd1b1
  0x0000000110bdd1a7: movabs $0x118,%rbx
  0x0000000110bdd1b1: mov    (%rdi,%rbx,1),%rax
  0x0000000110bdd1b5: lea    0x1(%rax),%rax
  0x0000000110bdd1b9: mov    %rax,(%rdi,%rbx,1)
  0x0000000110bdd1bd: je     0x0000000110bdd683  ;*ifnonnull
                                                ; - java.lang.AbstractStringBuilder::append@1 (line 445)

  0x0000000110bdd1c3: cmp    (%rdx),%rax        ;*invokevirtual length
                                                ; - java.lang.AbstractStringBuilder::append@10 (line 447)
                                                ; implicit exception: dispatches to 0x0000000110bdd6ca
  0x0000000110bdd1c6: mov    %rdx,%rdi
  0x0000000110bdd1c9: movabs $0x10dd78c90,%rbx  ;   {metadata(method data for {method} {0x000000010dbebf68} 'append' '(Ljava/lang/String;)Ljava/lang/AbstractStringBuilder;' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd1d3: mov    0x8(%rdi),%edi
  0x0000000110bdd1d6: shl    $0x3,%rdi
  0x0000000110bdd1da: cmp    0x140(%rbx),%rdi
  0x0000000110bdd1e1: jne    0x0000000110bdd1f0
  0x0000000110bdd1e3: addq   $0x1,0x148(%rbx)
  0x0000000110bdd1eb: jmpq   0x0000000110bdd256
  0x0000000110bdd1f0: cmp    0x150(%rbx),%rdi
  0x0000000110bdd1f7: jne    0x0000000110bdd206
  0x0000000110bdd1f9: addq   $0x1,0x158(%rbx)
  0x0000000110bdd201: jmpq   0x0000000110bdd256
  0x0000000110bdd206: cmpq   $0x0,0x140(%rbx)
  0x0000000110bdd211: jne    0x0000000110bdd22a
  0x0000000110bdd213: mov    %rdi,0x140(%rbx)
  0x0000000110bdd21a: movq   $0x1,0x148(%rbx)
  0x0000000110bdd225: jmpq   0x0000000110bdd256
  0x0000000110bdd22a: cmpq   $0x0,0x150(%rbx)
  0x0000000110bdd235: jne    0x0000000110bdd24e
  0x0000000110bdd237: mov    %rdi,0x150(%rbx)
  0x0000000110bdd23e: movq   $0x1,0x158(%rbx)
  0x0000000110bdd249: jmpq   0x0000000110bdd256
  0x0000000110bdd24e: addq   $0x1,0x138(%rbx)
  0x0000000110bdd256: movabs $0x10dd60ec0,%rdi  ;   {metadata(method data for {method} {0x000000010db79c60} 'length' '()I' in 'java/lang/String')}
  0x0000000110bdd260: mov    0xdc(%rdi),%ebx
  0x0000000110bdd266: add    $0x8,%ebx
  0x0000000110bdd269: mov    %ebx,0xdc(%rdi)
  0x0000000110bdd26f: movabs $0x10db79c60,%rdi  ;   {metadata({method} {0x000000010db79c60} 'length' '()I' in 'java/lang/String')}
  0x0000000110bdd279: and    $0x7ffff8,%ebx
  0x0000000110bdd27f: cmp    $0x0,%ebx
  0x0000000110bdd282: je     0x0000000110bdd6cf
  0x0000000110bdd288: mov    0xc(%rdx),%edi
  0x0000000110bdd28b: shl    $0x3,%rdi          ;*getfield value
                                                ; - java.lang.String::length@1 (line 623)
                                                ; - java.lang.AbstractStringBuilder::append@10 (line 447)

  0x0000000110bdd28f: mov    0xc(%rdi),%edi     ;*arraylength
                                                ; - java.lang.String::length@4 (line 623)
                                                ; - java.lang.AbstractStringBuilder::append@10 (line 447)
                                                ; implicit exception: dispatches to 0x0000000110bdd6e6
  0x0000000110bdd292: mov    %edi,0xac(%rsp)
  0x0000000110bdd299: mov    0xc(%rsi),%ebx     ;*getfield count
                                                ; - java.lang.AbstractStringBuilder::append@16 (line 448)

  0x0000000110bdd29c: add    %edi,%ebx
  0x0000000110bdd29e: mov    %rsi,%rax
  0x0000000110bdd2a1: movabs $0x10dd78c90,%rcx  ;   {metadata(method data for {method} {0x000000010dbebf68} 'append' '(Ljava/lang/String;)Ljava/lang/AbstractStringBuilder;' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd2ab: addq   $0x1,0x168(%rcx)
  0x0000000110bdd2b3: movabs $0x10dd6bec8,%rax  ;   {metadata(method data for {method} {0x000000010dbeb610} 'ensureCapacityInternal' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd2bd: mov    0xdc(%rax),%ecx
  0x0000000110bdd2c3: add    $0x8,%ecx
  0x0000000110bdd2c6: mov    %ecx,0xdc(%rax)
  0x0000000110bdd2cc: movabs $0x10dbeb610,%rax  ;   {metadata({method} {0x000000010dbeb610} 'ensureCapacityInternal' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd2d6: and    $0x7ffff8,%ecx
  0x0000000110bdd2dc: cmp    $0x0,%ecx
  0x0000000110bdd2df: je     0x0000000110bdd6eb
  0x0000000110bdd2e5: mov    0x10(%rsi),%eax
  0x0000000110bdd2e8: shl    $0x3,%rax          ;*getfield value
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@2 (line 123)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)

  0x0000000110bdd2ec: mov    0xc(%rax),%ecx     ;*arraylength
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@5 (line 123)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)
                                                ; implicit exception: dispatches to 0x0000000110bdd702
  0x0000000110bdd2ef: mov    %rbx,%r8
  0x0000000110bdd2f2: sub    %ecx,%r8d
  0x0000000110bdd2f5: cmp    $0x0,%r8d
  0x0000000110bdd2f9: movabs $0x10dd6bec8,%r8   ;   {metadata(method data for {method} {0x000000010dbeb610} 'ensureCapacityInternal' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd303: movabs $0x108,%r9
  0x0000000110bdd30d: jle    0x0000000110bdd31d
  0x0000000110bdd313: movabs $0x118,%r9
  0x0000000110bdd31d: mov    (%r8,%r9,1),%r11
  0x0000000110bdd321: lea    0x1(%r11),%r11
  0x0000000110bdd325: mov    %r11,(%r8,%r9,1)
  0x0000000110bdd329: jg     0x0000000110bdd33c  ;*ifle
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@7 (line 123)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)

  0x0000000110bdd32f: mov    %rdx,0xc0(%rsp)
  0x0000000110bdd337: jmpq   0x0000000110bdd59b  ;*return
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@26 (line 127)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)

  0x0000000110bdd33c: mov    %ecx,0xa8(%rsp)
  0x0000000110bdd343: mov    %rax,0xb0(%rsp)
  0x0000000110bdd34b: mov    %rdx,0xc0(%rsp)
  0x0000000110bdd353: mov    %rsi,%r8
  0x0000000110bdd356: movabs $0x10dd6bec8,%r9   ;   {metadata(method data for {method} {0x000000010dbeb610} 'ensureCapacityInternal' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd360: addq   $0x1,0x128(%r9)
  0x0000000110bdd368: mov    %rbx,%rdx
  0x0000000110bdd36b: mov    %rsi,%rbx
  0x0000000110bdd36e: mov    %rbx,%rsi          ;*invokespecial newCapacity
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@17 (line 125)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)

  0x0000000110bdd371: nop
  0x0000000110bdd372: nop
  0x0000000110bdd373: nop
  0x0000000110bdd374: nop
  0x0000000110bdd375: nop
  0x0000000110bdd376: nop
  0x0000000110bdd377: callq  0x0000000110b110a0  ; OopMap{[184]=Oop [192]=Oop [176]=Oop off=604}
                                                ;*invokespecial newCapacity
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@17 (line 125)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)
                                                ;   {optimized virtual_call}
  0x0000000110bdd37c: mov    %rax,%r8           ;*invokespecial newCapacity
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@17 (line 125)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)

  0x0000000110bdd37f: movabs $0x10dd6bec8,%rbx  ;   {metadata(method data for {method} {0x000000010dbeb610} 'ensureCapacityInternal' '(I)V' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd389: addq   $0x1,0x138(%rbx)
  0x0000000110bdd391: movabs $0x10dd6c208,%rbx  ;   {metadata(method data for {method} {0x000000010dc914b8} 'copyOf' '([CI)[C' in 'java/util/Arrays')}
  0x0000000110bdd39b: mov    0xdc(%rbx),%edx
  0x0000000110bdd3a1: add    $0x8,%edx
  0x0000000110bdd3a4: mov    %edx,0xdc(%rbx)
  0x0000000110bdd3aa: movabs $0x10dc914b8,%rbx  ;   {metadata({method} {0x000000010dc914b8} 'copyOf' '([CI)[C' in 'java/util/Arrays')}
  0x0000000110bdd3b4: and    $0x7ffff8,%edx
  0x0000000110bdd3ba: cmp    $0x0,%edx
  0x0000000110bdd3bd: je     0x0000000110bdd707
  0x0000000110bdd3c3: mov    %r8,%rbx
  0x0000000110bdd3c6: movabs $0x7c0000208,%rdx  ;   {metadata({type array char})}
  0x0000000110bdd3d0: movslq %ebx,%rbx
  0x0000000110bdd3d3: mov    %rbx,%rdi
  0x0000000110bdd3d6: cmp    $0xffffff,%rbx
  0x0000000110bdd3dd: ja     0x0000000110bdd71e
  0x0000000110bdd3e3: movabs $0x17,%rsi
  0x0000000110bdd3ed: lea    (%rsi,%rbx,2),%rsi
  0x0000000110bdd3f1: and    $0xfffffffffffffff8,%rsi
  0x0000000110bdd3f5: mov    0x60(%r15),%rax
  0x0000000110bdd3f9: lea    (%rax,%rsi,1),%rsi
  0x0000000110bdd3fd: cmp    0x70(%r15),%rsi
  0x0000000110bdd401: ja     0x0000000110bdd71e
  0x0000000110bdd407: mov    %rsi,0x60(%r15)
  0x0000000110bdd40b: sub    %rax,%rsi
  0x0000000110bdd40e: movq   $0x1,(%rax)
  0x0000000110bdd415: mov    %rdx,%rcx
  0x0000000110bdd418: shr    $0x3,%rcx
  0x0000000110bdd41c: mov    %ecx,0x8(%rax)
  0x0000000110bdd41f: mov    %ebx,0xc(%rax)
  0x0000000110bdd422: sub    $0x10,%rsi
  0x0000000110bdd426: je     0x0000000110bdd43d
  0x0000000110bdd42c: xor    %rbx,%rbx
  0x0000000110bdd42f: shr    $0x3,%rsi
  0x0000000110bdd433: mov    %rbx,0x8(%rax,%rsi,8)
  0x0000000110bdd438: dec    %rsi
  0x0000000110bdd43b: jne    0x0000000110bdd433  ;*newarray
                                                ; - java.util.Arrays::copyOf@1 (line 3332)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)

  0x0000000110bdd43d: movabs $0x10dd6c208,%rsi  ;   {metadata(method data for {method} {0x000000010dc914b8} 'copyOf' '([CI)[C' in 'java/util/Arrays')}
  0x0000000110bdd447: addq   $0x1,0x108(%rsi)
  0x0000000110bdd44f: movabs $0x10dd43210,%rsi  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bdd459: mov    0xdc(%rsi),%edx
  0x0000000110bdd45f: add    $0x8,%edx
  0x0000000110bdd462: mov    %edx,0xdc(%rsi)
  0x0000000110bdd468: movabs $0x10dc6cd70,%rsi  ;   {metadata({method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bdd472: and    $0x7ffff8,%edx
  0x0000000110bdd478: cmp    $0x0,%edx
  0x0000000110bdd47b: je     0x0000000110bdd728
  0x0000000110bdd481: mov    0xa8(%rsp),%ecx
  0x0000000110bdd488: cmp    %r8d,%ecx
  0x0000000110bdd48b: movabs $0x10dd43210,%rsi  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bdd495: movabs $0x108,%rdx
  0x0000000110bdd49f: jg     0x0000000110bdd4af
  0x0000000110bdd4a5: movabs $0x118,%rdx
  0x0000000110bdd4af: mov    (%rsi,%rdx,1),%r9
  0x0000000110bdd4b3: lea    0x1(%r9),%r9
  0x0000000110bdd4b7: mov    %r9,(%rsi,%rdx,1)
  0x0000000110bdd4bb: jg     0x0000000110bdd4d9  ;*if_icmpgt
                                                ; - java.lang.Math::min@2 (line 1336)
                                                ; - java.util.Arrays::copyOf@11 (line 3334)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)

  0x0000000110bdd4c1: movabs $0x10dd43210,%rsi  ;   {metadata(method data for {method} {0x000000010dc6cd70} 'min' '(II)I' in 'java/lang/Math')}
  0x0000000110bdd4cb: incl   0x128(%rsi)
  0x0000000110bdd4d1: mov    %rcx,%r9
  0x0000000110bdd4d4: jmpq   0x0000000110bdd4dc  ;*goto
                                                ; - java.lang.Math::min@6 (line 1336)
                                                ; - java.util.Arrays::copyOf@11 (line 3334)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)

  0x0000000110bdd4d9: mov    %r8,%r9            ;*ireturn
                                                ; - java.lang.Math::min@10 (line 1336)
                                                ; - java.util.Arrays::copyOf@11 (line 3334)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)

  0x0000000110bdd4dc: mov    0xb0(%rsp),%rsi
  0x0000000110bdd4e4: movabs $0x10dd6c208,%rdx  ;   {metadata(method data for {method} {0x000000010dc914b8} 'copyOf' '([CI)[C' in 'java/util/Arrays')}
  0x0000000110bdd4ee: addq   $0x1,0x118(%rdx)
  0x0000000110bdd4f6: mov    $0x0,%edx
  0x0000000110bdd4fb: mov    %rax,%rcx
  0x0000000110bdd4fe: mov    $0x0,%r8d
  0x0000000110bdd504: mov    %rax,0xc8(%rsp)
  0x0000000110bdd50c: lea    (%rdx,%r9,1),%rdi
  0x0000000110bdd510: cmp    0xc(%rsi),%edi
  0x0000000110bdd513: ja     0x0000000110bdd73f
  0x0000000110bdd519: lea    (%r8,%r9,1),%rdi
  0x0000000110bdd51d: cmp    0xc(%rcx),%edi
  0x0000000110bdd520: ja     0x0000000110bdd73f
  0x0000000110bdd526: test   %r9d,%r9d
  0x0000000110bdd529: jl     0x0000000110bdd73f
  0x0000000110bdd52f: je     0x0000000110bdd56b
  0x0000000110bdd535: movslq %edx,%rdx
  0x0000000110bdd538: movslq %r8d,%r8
  0x0000000110bdd53b: lea    0x10(%rsi,%rdx,2),%rdi
  0x0000000110bdd540: lea    0x10(%rcx,%r8,2),%rsi
  0x0000000110bdd545: mov    %r9,%rdx
  0x0000000110bdd548: test   $0xf,%esp
  0x0000000110bdd54e: je     0x0000000110bdd566
  0x0000000110bdd554: sub    $0x8,%rsp
  0x0000000110bdd558: callq  Stub::jshort_disjoint_arraycopy
                                                ;   {runtime_call}
  0x0000000110bdd55d: add    $0x8,%rsp
  0x0000000110bdd561: jmpq   0x0000000110bdd56b
  0x0000000110bdd566: callq  Stub::jshort_disjoint_arraycopy
                                                ;*invokestatic arraycopy
                                                ; - java.util.Arrays::copyOf@14 (line 3333)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)
                                                ;   {runtime_call}
  0x0000000110bdd56b: mov    0xc8(%rsp),%rax
  0x0000000110bdd573: mov    0xb8(%rsp),%rsi
  0x0000000110bdd57b: mov    %rax,%r10
  0x0000000110bdd57e: shr    $0x3,%r10
  0x0000000110bdd582: mov    %r10d,0x10(%rsi)
  0x0000000110bdd586: mov    %rsi,%rdx
  0x0000000110bdd589: shr    $0x9,%rdx
  0x0000000110bdd58d: movabs $0x100fcf000,%rcx
  0x0000000110bdd597: movb   $0x0,(%rdx,%rcx,1)  ;*putfield value
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@23 (line 124)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)

  0x0000000110bdd59b: mov    0xac(%rsp),%ebx
  0x0000000110bdd5a2: mov    0xc0(%rsp),%rdi
  0x0000000110bdd5aa: mov    0x10(%rsi),%r8d
  0x0000000110bdd5ae: shl    $0x3,%r8           ;*getfield value
                                                ; - java.lang.AbstractStringBuilder::append@28 (line 449)

  0x0000000110bdd5b2: mov    0xc(%rsi),%r9d     ;*getfield count
                                                ; - java.lang.AbstractStringBuilder::append@32 (line 449)

  0x0000000110bdd5b6: mov    %rdi,%rdx
  0x0000000110bdd5b9: movabs $0x10dd78c90,%rcx  ;   {metadata(method data for {method} {0x000000010dbebf68} 'append' '(Ljava/lang/String;)Ljava/lang/AbstractStringBuilder;' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd5c3: mov    0x8(%rdx),%edx
  0x0000000110bdd5c6: shl    $0x3,%rdx
  0x0000000110bdd5ca: cmp    0x180(%rcx),%rdx
  0x0000000110bdd5d1: jne    0x0000000110bdd5e0
  0x0000000110bdd5d3: addq   $0x1,0x188(%rcx)
  0x0000000110bdd5db: jmpq   0x0000000110bdd646
  0x0000000110bdd5e0: cmp    0x190(%rcx),%rdx
  0x0000000110bdd5e7: jne    0x0000000110bdd5f6
  0x0000000110bdd5e9: addq   $0x1,0x198(%rcx)
  0x0000000110bdd5f1: jmpq   0x0000000110bdd646
  0x0000000110bdd5f6: cmpq   $0x0,0x180(%rcx)
  0x0000000110bdd601: jne    0x0000000110bdd61a
  0x0000000110bdd603: mov    %rdx,0x180(%rcx)
  0x0000000110bdd60a: movq   $0x1,0x188(%rcx)
  0x0000000110bdd615: jmpq   0x0000000110bdd646
  0x0000000110bdd61a: cmpq   $0x0,0x190(%rcx)
  0x0000000110bdd625: jne    0x0000000110bdd63e
  0x0000000110bdd627: mov    %rdx,0x190(%rcx)
  0x0000000110bdd62e: movq   $0x1,0x198(%rcx)
  0x0000000110bdd639: jmpq   0x0000000110bdd646
  0x0000000110bdd63e: addq   $0x1,0x178(%rcx)
  0x0000000110bdd646: mov    $0x0,%edx
  0x0000000110bdd64b: mov    %rbx,%rcx
  0x0000000110bdd64e: mov    %rdi,%rsi          ;*invokevirtual getChars
                                                ; - java.lang.AbstractStringBuilder::append@35 (line 449)

  0x0000000110bdd651: nop
  0x0000000110bdd652: nop
  0x0000000110bdd653: nop
  0x0000000110bdd654: nop
  0x0000000110bdd655: nop
  0x0000000110bdd656: nop
  0x0000000110bdd657: callq  0x0000000110b110a0  ; OopMap{[184]=Oop off=1340}
                                                ;*invokevirtual getChars
                                                ; - java.lang.AbstractStringBuilder::append@35 (line 449)
                                                ;   {optimized virtual_call}
  0x0000000110bdd65c: mov    0xb8(%rsp),%rsi
  0x0000000110bdd664: mov    0xc(%rsi),%eax     ;*getfield count
                                                ; - java.lang.AbstractStringBuilder::append@40 (line 450)

  0x0000000110bdd667: add    0xac(%rsp),%eax
  0x0000000110bdd66e: mov    %eax,0xc(%rsi)     ;*putfield count
                                                ; - java.lang.AbstractStringBuilder::append@45 (line 450)

  0x0000000110bdd671: mov    %rsi,%rax
  0x0000000110bdd674: add    $0xe0,%rsp
  0x0000000110bdd67b: pop    %rbp
  0x0000000110bdd67c: test   %eax,-0xf1e6582(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdd682: retq                      ;*areturn
                                                ; - java.lang.AbstractStringBuilder::append@49 (line 451)

  0x0000000110bdd683: mov    %rsi,%rdi
  0x0000000110bdd686: movabs $0x10dd78c90,%rbx  ;   {metadata(method data for {method} {0x000000010dbebf68} 'append' '(Ljava/lang/String;)Ljava/lang/AbstractStringBuilder;' in 'java/lang/AbstractStringBuilder')}
  0x0000000110bdd690: addq   $0x1,0x128(%rbx)
  0x0000000110bdd698: nop
  0x0000000110bdd699: nop
  0x0000000110bdd69a: nop
  0x0000000110bdd69b: nop
  0x0000000110bdd69c: nop
  0x0000000110bdd69d: nop
  0x0000000110bdd69e: nop
  0x0000000110bdd69f: callq  0x0000000110b110a0  ; OopMap{off=1412}
                                                ;*invokespecial appendNull
                                                ; - java.lang.AbstractStringBuilder::append@5 (line 446)
                                                ;   {optimized virtual_call}
  0x0000000110bdd6a4: add    $0xe0,%rsp
  0x0000000110bdd6ab: pop    %rbp
  0x0000000110bdd6ac: test   %eax,-0xf1e65b2(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bdd6b2: retq   
  0x0000000110bdd6b3: mov    %rdi,0x8(%rsp)
  0x0000000110bdd6b8: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bdd6c0: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop [184]=Oop rdx=Oop off=1445}
                                                ;*synchronization entry
                                                ; - java.lang.AbstractStringBuilder::append@-1 (line 445)
                                                ;   {runtime_call}
  0x0000000110bdd6c5: jmpq   0x0000000110bdd189
  0x0000000110bdd6ca: callq  0x0000000110bc6240  ; OopMap{rsi=Oop [184]=Oop rdx=Oop off=1455}
                                                ;*invokevirtual length
                                                ; - java.lang.AbstractStringBuilder::append@10 (line 447)
                                                ;   {runtime_call}
  0x0000000110bdd6cf: mov    %rdi,0x8(%rsp)
  0x0000000110bdd6d4: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bdd6dc: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop [184]=Oop rdx=Oop off=1473}
                                                ;*synchronization entry
                                                ; - java.lang.String::length@-1 (line 623)
                                                ; - java.lang.AbstractStringBuilder::append@10 (line 447)
                                                ;   {runtime_call}
  0x0000000110bdd6e1: jmpq   0x0000000110bdd288
  0x0000000110bdd6e6: callq  0x0000000110bc6240  ; OopMap{rsi=Oop [184]=Oop rdx=Oop off=1483}
                                                ;*arraylength
                                                ; - java.lang.String::length@4 (line 623)
                                                ; - java.lang.AbstractStringBuilder::append@10 (line 447)
                                                ;   {runtime_call}
  0x0000000110bdd6eb: mov    %rax,0x8(%rsp)
  0x0000000110bdd6f0: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bdd6f8: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop [184]=Oop rdx=Oop off=1501}
                                                ;*synchronization entry
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@-1 (line 123)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)
                                                ;   {runtime_call}
  0x0000000110bdd6fd: jmpq   0x0000000110bdd2e5
  0x0000000110bdd702: callq  0x0000000110bc6240  ; OopMap{rsi=Oop [184]=Oop rdx=Oop rax=Oop off=1511}
                                                ;*arraylength
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@5 (line 123)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)
                                                ;   {runtime_call}
  0x0000000110bdd707: mov    %rbx,0x8(%rsp)
  0x0000000110bdd70c: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bdd714: callq  0x0000000110bca9e0  ; OopMap{[184]=Oop [192]=Oop [176]=Oop off=1529}
                                                ;*synchronization entry
                                                ; - java.util.Arrays::copyOf@-1 (line 3332)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)
                                                ;   {runtime_call}
  0x0000000110bdd719: jmpq   0x0000000110bdd3c3
  0x0000000110bdd71e: callq  0x0000000110bc72a0  ; OopMap{[184]=Oop [192]=Oop [176]=Oop off=1539}
                                                ;*newarray
                                                ; - java.util.Arrays::copyOf@1 (line 3332)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)
                                                ;   {runtime_call}
  0x0000000110bdd723: jmpq   0x0000000110bdd43d
  0x0000000110bdd728: mov    %rsi,0x8(%rsp)
  0x0000000110bdd72d: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bdd735: callq  0x0000000110bca9e0  ; OopMap{[184]=Oop [192]=Oop [176]=Oop rax=Oop off=1562}
                                                ;*synchronization entry
                                                ; - java.lang.Math::min@-1 (line 1336)
                                                ; - java.util.Arrays::copyOf@11 (line 3334)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)
                                                ;   {runtime_call}
  0x0000000110bdd73a: jmpq   0x0000000110bdd481
  0x0000000110bdd73f: callq  0x0000000110b11520  ; OopMap{[184]=Oop [192]=Oop [200]=Oop off=1572}
                                                ;*invokestatic arraycopy
                                                ; - java.util.Arrays::copyOf@14 (line 3333)
                                                ; - java.lang.AbstractStringBuilder::ensureCapacityInternal@20 (line 124)
                                                ; - java.lang.AbstractStringBuilder::append@21 (line 448)
                                                ;   {static_call}
  0x0000000110bdd744: jmpq   0x0000000110bdd56b
  0x0000000110bdd749: nop
  0x0000000110bdd74a: nop
  0x0000000110bdd74b: mov    0x2a8(%r15),%rax
  0x0000000110bdd752: movabs $0x0,%r10
  0x0000000110bdd75c: mov    %r10,0x2a8(%r15)
  0x0000000110bdd763: movabs $0x0,%r10
  0x0000000110bdd76d: mov    %r10,0x2b0(%r15)
  0x0000000110bdd774: add    $0xe0,%rsp
  0x0000000110bdd77b: pop    %rbp
  0x0000000110bdd77c: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bdd781: hlt    
  0x0000000110bdd782: hlt    
  0x0000000110bdd783: hlt    
  0x0000000110bdd784: hlt    
  0x0000000110bdd785: hlt    
  0x0000000110bdd786: hlt    
  0x0000000110bdd787: hlt    
  0x0000000110bdd788: hlt    
  0x0000000110bdd789: hlt    
  0x0000000110bdd78a: hlt    
  0x0000000110bdd78b: hlt    
  0x0000000110bdd78c: hlt    
  0x0000000110bdd78d: hlt    
  0x0000000110bdd78e: hlt    
  0x0000000110bdd78f: hlt    
  0x0000000110bdd790: hlt    
  0x0000000110bdd791: hlt    
  0x0000000110bdd792: hlt    
  0x0000000110bdd793: hlt    
  0x0000000110bdd794: hlt    
  0x0000000110bdd795: hlt    
  0x0000000110bdd796: hlt    
  0x0000000110bdd797: hlt    
  0x0000000110bdd798: hlt    
  0x0000000110bdd799: hlt    
  0x0000000110bdd79a: hlt    
  0x0000000110bdd79b: hlt    
  0x0000000110bdd79c: hlt    
  0x0000000110bdd79d: hlt    
  0x0000000110bdd79e: hlt    
  0x0000000110bdd79f: hlt    
[Stub Code]
  0x0000000110bdd7a0: nop                       ;   {no_reloc}
  0x0000000110bdd7a1: nop
  0x0000000110bdd7a2: nop
  0x0000000110bdd7a3: nop
  0x0000000110bdd7a4: nop
  0x0000000110bdd7a5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bdd7af: jmpq   0x0000000110bdd7af  ;   {runtime_call}
  0x0000000110bdd7b4: nop
  0x0000000110bdd7b5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bdd7bf: jmpq   0x0000000110bdd7bf  ;   {runtime_call}
  0x0000000110bdd7c4: nop
  0x0000000110bdd7c5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bdd7cf: jmpq   0x0000000110bdd7cf  ;   {runtime_call}
  0x0000000110bdd7d4: nop
  0x0000000110bdd7d5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bdd7df: jmpq   0x0000000110bdd7df  ;   {runtime_call}
[Exception Handler]
  0x0000000110bdd7e4: callq  0x0000000110bc80e0  ;   {runtime_call}
  0x0000000110bdd7e9: mov    %rsp,-0x28(%rsp)
  0x0000000110bdd7ee: sub    $0x80,%rsp
  0x0000000110bdd7f5: mov    %rax,0x78(%rsp)
  0x0000000110bdd7fa: mov    %rcx,0x70(%rsp)
  0x0000000110bdd7ff: mov    %rdx,0x68(%rsp)
  0x0000000110bdd804: mov    %rbx,0x60(%rsp)
  0x0000000110bdd809: mov    %rbp,0x50(%rsp)
  0x0000000110bdd80e: mov    %rsi,0x48(%rsp)
  0x0000000110bdd813: mov    %rdi,0x40(%rsp)
  0x0000000110bdd818: mov    %r8,0x38(%rsp)
  0x0000000110bdd81d: mov    %r9,0x30(%rsp)
  0x0000000110bdd822: mov    %r10,0x28(%rsp)
  0x0000000110bdd827: mov    %r11,0x20(%rsp)
  0x0000000110bdd82c: mov    %r12,0x18(%rsp)
  0x0000000110bdd831: mov    %r13,0x10(%rsp)
  0x0000000110bdd836: mov    %r14,0x8(%rsp)
  0x0000000110bdd83b: mov    %r15,(%rsp)
  0x0000000110bdd83f: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bdd849: movabs $0x110bdd7e9,%rsi  ;   {internal_word}
  0x0000000110bdd853: mov    %rsp,%rdx
  0x0000000110bdd856: and    $0xfffffffffffffff0,%rsp
  0x0000000110bdd85a: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bdd85f: hlt    
[Deopt Handler Code]
  0x0000000110bdd860: movabs $0x110bdd860,%r10  ;   {section_word}
  0x0000000110bdd86a: push   %r10
  0x0000000110bdd86c: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bdd871: hlt    
  0x0000000110bdd872: hlt    
  0x0000000110bdd873: hlt    
  0x0000000110bdd874: hlt    
  0x0000000110bdd875: hlt    
  0x0000000110bdd876: hlt    
  0x0000000110bdd877: hlt    
Decoding compiled method 0x0000000110bddd10:
Code:
[Entry Point]
[Constants]
  # {method} {0x000000010db7b098} 'indexOf' '(I)I' in 'java/lang/String'
  # this:     rsi:rsi   = 'java/lang/String'
  # parm0:    rdx       = int
  #           [sp+0x40]  (sp of caller)
  0x0000000110bdde80: mov    0x8(%rsi),%r10d
  0x0000000110bdde84: shl    $0x3,%r10
  0x0000000110bdde88: cmp    %rax,%r10
  0x0000000110bdde8b: jne    0x0000000110b10e60  ;   {runtime_call}
  0x0000000110bdde91: data16 data16 nopw 0x0(%rax,%rax,1)
  0x0000000110bdde9c: data16 data16 xchg %ax,%ax
[Verified Entry Point]
  0x0000000110bddea0: mov    %eax,-0x14000(%rsp)
  0x0000000110bddea7: push   %rbp
  0x0000000110bddea8: sub    $0x30,%rsp
  0x0000000110bddeac: movabs $0x10ddc19e0,%rcx  ;   {metadata(method data for {method} {0x000000010db7b098} 'indexOf' '(I)I' in 'java/lang/String')}
  0x0000000110bddeb6: mov    0xdc(%rcx),%edi
  0x0000000110bddebc: add    $0x8,%edi
  0x0000000110bddebf: mov    %edi,0xdc(%rcx)
  0x0000000110bddec5: movabs $0x10db7b098,%rcx  ;   {metadata({method} {0x000000010db7b098} 'indexOf' '(I)I' in 'java/lang/String')}
  0x0000000110bddecf: and    $0x1ff8,%edi
  0x0000000110bdded5: cmp    $0x0,%edi
  0x0000000110bdded8: je     0x0000000110bddf88  ;*aload_0
                                                ; - java.lang.String::indexOf@0 (line 1503)

  0x0000000110bddede: mov    %rsi,%rcx
  0x0000000110bddee1: movabs $0x10ddc19e0,%rdi  ;   {metadata(method data for {method} {0x000000010db7b098} 'indexOf' '(I)I' in 'java/lang/String')}
  0x0000000110bddeeb: mov    0x8(%rcx),%ecx
  0x0000000110bddeee: shl    $0x3,%rcx
  0x0000000110bddef2: cmp    0x110(%rdi),%rcx
  0x0000000110bddef9: jne    0x0000000110bddf08
  0x0000000110bddefb: addq   $0x1,0x118(%rdi)
  0x0000000110bddf03: jmpq   0x0000000110bddf6e
  0x0000000110bddf08: cmp    0x120(%rdi),%rcx
  0x0000000110bddf0f: jne    0x0000000110bddf1e
  0x0000000110bddf11: addq   $0x1,0x128(%rdi)
  0x0000000110bddf19: jmpq   0x0000000110bddf6e
  0x0000000110bddf1e: cmpq   $0x0,0x110(%rdi)
  0x0000000110bddf29: jne    0x0000000110bddf42
  0x0000000110bddf2b: mov    %rcx,0x110(%rdi)
  0x0000000110bddf32: movq   $0x1,0x118(%rdi)
  0x0000000110bddf3d: jmpq   0x0000000110bddf6e
  0x0000000110bddf42: cmpq   $0x0,0x120(%rdi)
  0x0000000110bddf4d: jne    0x0000000110bddf66
  0x0000000110bddf4f: mov    %rcx,0x120(%rdi)
  0x0000000110bddf56: movq   $0x1,0x128(%rdi)
  0x0000000110bddf61: jmpq   0x0000000110bddf6e
  0x0000000110bddf66: addq   $0x1,0x108(%rdi)
  0x0000000110bddf6e: mov    $0x0,%ecx          ;*invokevirtual indexOf
                                                ; - java.lang.String::indexOf@3 (line 1503)

  0x0000000110bddf73: nop
  0x0000000110bddf74: nop
  0x0000000110bddf75: nop
  0x0000000110bddf76: nop
  0x0000000110bddf77: callq  0x0000000110b110a0  ; OopMap{off=252}
                                                ;*invokevirtual indexOf
                                                ; - java.lang.String::indexOf@3 (line 1503)
                                                ;   {optimized virtual_call}
  0x0000000110bddf7c: add    $0x30,%rsp
  0x0000000110bddf80: pop    %rbp
  0x0000000110bddf81: test   %eax,-0xf1e6e87(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bddf87: retq   
  0x0000000110bddf88: mov    %rcx,0x8(%rsp)
  0x0000000110bddf8d: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bddf95: callq  0x0000000110bca9e0  ; OopMap{rsi=Oop off=282}
                                                ;*synchronization entry
                                                ; - java.lang.String::indexOf@-1 (line 1503)
                                                ;   {runtime_call}
  0x0000000110bddf9a: jmpq   0x0000000110bddede
  0x0000000110bddf9f: nop
  0x0000000110bddfa0: nop
  0x0000000110bddfa1: mov    0x2a8(%r15),%rax
  0x0000000110bddfa8: movabs $0x0,%r10
  0x0000000110bddfb2: mov    %r10,0x2a8(%r15)
  0x0000000110bddfb9: movabs $0x0,%r10
  0x0000000110bddfc3: mov    %r10,0x2b0(%r15)
  0x0000000110bddfca: add    $0x30,%rsp
  0x0000000110bddfce: pop    %rbp
  0x0000000110bddfcf: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bddfd4: hlt    
  0x0000000110bddfd5: hlt    
  0x0000000110bddfd6: hlt    
  0x0000000110bddfd7: hlt    
  0x0000000110bddfd8: hlt    
  0x0000000110bddfd9: hlt    
  0x0000000110bddfda: hlt    
  0x0000000110bddfdb: hlt    
  0x0000000110bddfdc: hlt    
  0x0000000110bddfdd: hlt    
  0x0000000110bddfde: hlt    
  0x0000000110bddfdf: hlt    
[Stub Code]
  0x0000000110bddfe0: nop                       ;   {no_reloc}
  0x0000000110bddfe1: nop
  0x0000000110bddfe2: nop
  0x0000000110bddfe3: nop
  0x0000000110bddfe4: nop
  0x0000000110bddfe5: movabs $0x0,%rbx          ;   {static_stub}
  0x0000000110bddfef: jmpq   0x0000000110bddfef  ;   {runtime_call}
[Exception Handler]
  0x0000000110bddff4: callq  0x0000000110bc80e0  ;   {runtime_call}
  0x0000000110bddff9: mov    %rsp,-0x28(%rsp)
  0x0000000110bddffe: sub    $0x80,%rsp
  0x0000000110bde005: mov    %rax,0x78(%rsp)
  0x0000000110bde00a: mov    %rcx,0x70(%rsp)
  0x0000000110bde00f: mov    %rdx,0x68(%rsp)
  0x0000000110bde014: mov    %rbx,0x60(%rsp)
  0x0000000110bde019: mov    %rbp,0x50(%rsp)
  0x0000000110bde01e: mov    %rsi,0x48(%rsp)
  0x0000000110bde023: mov    %rdi,0x40(%rsp)
  0x0000000110bde028: mov    %r8,0x38(%rsp)
  0x0000000110bde02d: mov    %r9,0x30(%rsp)
  0x0000000110bde032: mov    %r10,0x28(%rsp)
  0x0000000110bde037: mov    %r11,0x20(%rsp)
  0x0000000110bde03c: mov    %r12,0x18(%rsp)
  0x0000000110bde041: mov    %r13,0x10(%rsp)
  0x0000000110bde046: mov    %r14,0x8(%rsp)
  0x0000000110bde04b: mov    %r15,(%rsp)
  0x0000000110bde04f: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bde059: movabs $0x110bddff9,%rsi  ;   {internal_word}
  0x0000000110bde063: mov    %rsp,%rdx
  0x0000000110bde066: and    $0xfffffffffffffff0,%rsp
  0x0000000110bde06a: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bde06f: hlt    
[Deopt Handler Code]
  0x0000000110bde070: movabs $0x110bde070,%r10  ;   {section_word}
  0x0000000110bde07a: push   %r10
  0x0000000110bde07c: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bde081: hlt    
  0x0000000110bde082: hlt    
  0x0000000110bde083: hlt    
  0x0000000110bde084: hlt    
  0x0000000110bde085: hlt    
  0x0000000110bde086: hlt    
  0x0000000110bde087: hlt    
305419897
Decoding compiled method 0x0000000110bde150:
Code:
[Entry Point]
[Verified Entry Point]
[Constants]
  # {method} {0x000000010db8f6b0} 'getSecurityManager' '()Ljava/lang/SecurityManager;' in 'java/lang/System'
  #           [sp+0x40]  (sp of caller)
  0x0000000110bde2a0: mov    %eax,-0x14000(%rsp)
  0x0000000110bde2a7: push   %rbp
  0x0000000110bde2a8: sub    $0x30,%rsp
  0x0000000110bde2ac: movabs $0x10ddca9b8,%rax  ;   {metadata(method data for {method} {0x000000010db8f6b0} 'getSecurityManager' '()Ljava/lang/SecurityManager;' in 'java/lang/System')}
  0x0000000110bde2b6: mov    0xdc(%rax),%esi
  0x0000000110bde2bc: add    $0x8,%esi
  0x0000000110bde2bf: mov    %esi,0xdc(%rax)
  0x0000000110bde2c5: movabs $0x10db8f6b0,%rax  ;   {metadata({method} {0x000000010db8f6b0} 'getSecurityManager' '()Ljava/lang/SecurityManager;' in 'java/lang/System')}
  0x0000000110bde2cf: and    $0x1ff8,%esi
  0x0000000110bde2d5: cmp    $0x0,%esi
  0x0000000110bde2d8: je     0x0000000110bde2fb
  0x0000000110bde2de: movabs $0x76ab00c78,%rax  ;   {oop(a 'java/lang/Class' = 'java/lang/System')}
  0x0000000110bde2e8: mov    0x74(%rax),%eax
  0x0000000110bde2eb: shl    $0x3,%rax          ;*getstatic security
                                                ; - java.lang.System::getSecurityManager@0 (line 334)

  0x0000000110bde2ef: add    $0x30,%rsp
  0x0000000110bde2f3: pop    %rbp
  0x0000000110bde2f4: test   %eax,-0xf1e71fa(%rip)        # 0x00000001019f7100
                                                ;   {poll_return}
  0x0000000110bde2fa: retq   
  0x0000000110bde2fb: mov    %rax,0x8(%rsp)
  0x0000000110bde300: movq   $0xffffffffffffffff,(%rsp)
  0x0000000110bde308: callq  0x0000000110bca9e0  ; OopMap{off=109}
                                                ;*synchronization entry
                                                ; - java.lang.System::getSecurityManager@-1 (line 334)
                                                ;   {runtime_call}
  0x0000000110bde30d: jmp    0x0000000110bde2de
  0x0000000110bde30f: nop
  0x0000000110bde310: nop
  0x0000000110bde311: mov    0x2a8(%r15),%rax
  0x0000000110bde318: movabs $0x0,%r10
  0x0000000110bde322: mov    %r10,0x2a8(%r15)
  0x0000000110bde329: movabs $0x0,%r10
  0x0000000110bde333: mov    %r10,0x2b0(%r15)
  0x0000000110bde33a: add    $0x30,%rsp
  0x0000000110bde33e: pop    %rbp
  0x0000000110bde33f: jmpq   0x0000000110b38ca0  ;   {runtime_call}
  0x0000000110bde344: hlt    
  0x0000000110bde345: hlt    
  0x0000000110bde346: hlt    
  0x0000000110bde347: hlt    
  0x0000000110bde348: hlt    
  0x0000000110bde349: hlt    
  0x0000000110bde34a: hlt    
  0x0000000110bde34b: hlt    
  0x0000000110bde34c: hlt    
  0x0000000110bde34d: hlt    
  0x0000000110bde34e: hlt    
  0x0000000110bde34f: hlt    
  0x0000000110bde350: hlt    
  0x0000000110bde351: hlt    
  0x0000000110bde352: hlt    
  0x0000000110bde353: hlt    
  0x0000000110bde354: hlt    
  0x0000000110bde355: hlt    
  0x0000000110bde356: hlt    
  0x0000000110bde357: hlt    
  0x0000000110bde358: hlt    
  0x0000000110bde359: hlt    
  0x0000000110bde35a: hlt    
  0x0000000110bde35b: hlt    
  0x0000000110bde35c: hlt    
  0x0000000110bde35d: hlt    
  0x0000000110bde35e: hlt    
  0x0000000110bde35f: hlt    
[Exception Handler]
[Stub Code]
  0x0000000110bde360: callq  0x0000000110bc80e0  ;   {no_reloc}
  0x0000000110bde365: mov    %rsp,-0x28(%rsp)
  0x0000000110bde36a: sub    $0x80,%rsp
  0x0000000110bde371: mov    %rax,0x78(%rsp)
  0x0000000110bde376: mov    %rcx,0x70(%rsp)
  0x0000000110bde37b: mov    %rdx,0x68(%rsp)
  0x0000000110bde380: mov    %rbx,0x60(%rsp)
  0x0000000110bde385: mov    %rbp,0x50(%rsp)
  0x0000000110bde38a: mov    %rsi,0x48(%rsp)
  0x0000000110bde38f: mov    %rdi,0x40(%rsp)
  0x0000000110bde394: mov    %r8,0x38(%rsp)
  0x0000000110bde399: mov    %r9,0x30(%rsp)
  0x0000000110bde39e: mov    %r10,0x28(%rsp)
  0x0000000110bde3a3: mov    %r11,0x20(%rsp)
  0x0000000110bde3a8: mov    %r12,0x18(%rsp)
  0x0000000110bde3ad: mov    %r13,0x10(%rsp)
  0x0000000110bde3b2: mov    %r14,0x8(%rsp)
  0x0000000110bde3b7: mov    %r15,(%rsp)
  0x0000000110bde3bb: movabs $0x1037e4764,%rdi  ;   {external_word}
  0x0000000110bde3c5: movabs $0x110bde365,%rsi  ;   {internal_word}
  0x0000000110bde3cf: mov    %rsp,%rdx
  0x0000000110bde3d2: and    $0xfffffffffffffff0,%rsp
  0x0000000110bde3d6: callq  0x00000001036089e2  ;   {runtime_call}
  0x0000000110bde3db: hlt    
[Deopt Handler Code]
  0x0000000110bde3dc: movabs $0x110bde3dc,%r10  ;   {section_word}
  0x0000000110bde3e6: push   %r10
  0x0000000110bde3e8: jmpq   0x0000000110b12500  ;   {runtime_call}
  0x0000000110bde3ed: hlt    
  0x0000000110bde3ee: hlt    
  0x0000000110bde3ef: hlt    
