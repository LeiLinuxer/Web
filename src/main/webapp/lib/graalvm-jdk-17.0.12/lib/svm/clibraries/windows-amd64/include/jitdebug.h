/*
 * Copyright (c) 2016, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

#ifndef SVM_NATIVE_JITDEBUG_H
#define SVM_NATIVE_JITDEBUG_H

#include <stdint.h>

struct jit_code_entry
{
  struct jit_code_entry *next_entry;
  struct jit_code_entry *prev_entry;
  const char *symfile_addr;
  uint64_t symfile_size;
};

struct jit_code_entry *register_jitcode(const char *addr, uint64_t size);
void unregister_jitcode(struct jit_code_entry *const entry);

#endif
