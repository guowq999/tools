-- 锁的key
local key = KEYS[1]
-- 当前线程id
local threadId = ARGV[1]

-- 获取锁中的value
local id = redis.call('get', key)
-- 比较线程id与锁中的id是否一致
if(id == threadId) then
    -- 释放锁
    return redis.call('del', key)
end
return 0