#include <map>
#include <algorithm>
using namespace std;
struct Node {
    int num;
    int times;
}st[100005];
int cnt;
map<int, int>mp;
struct Cmp {
    bool operator() (const Node& n1, const Node& n2) {
        //times降序，num升序
        return n1.times != n2.times ? n1.times > n2.times:n1.num < n2.num;
    }
};

class Solution {
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        mp.clear();
        for (int i = 0; i < nums.size(); ++i) {
            if (mp[nums[i]] == 0) {
                mp[nums[i]] = 1;
            } else {
                mp[nums[i]] = mp[nums[i]] + 1;
            }
        }
        map<int, int>::iterator it;
        cnt = 0;
        for (it = mp.begin(); it != mp.end(); ++it) {
            st[cnt].num = it -> first;
            st[cnt++].times = it -> second;
        }
        sort(&st[0], &st[cnt], Cmp());
        vector<int> res;
        for (int i = 0; i < k && i < cnt; ++i) {
            res.push_back(st[i].num);
        }
        return res;
    }
};

/**
// 排序元素，比较的对象
struct Person
{
  Person(int id, const string& name, int age): id_(id), name_(name), age_(age)
  {}
  
  int id_;
  string name_;
  int age_;
};


// 方式1：重载operator<用于排序时的比较(写在函数体内)
bool operator< (const Person& rt)
{
  return this->id_ < rt.id_;
}

// 排序函数写法，默认调用operator<
sort(members.begin(), members.end());

// 方式2：写比较函数
bool CompAge(const Person& pl, const Person& pr)
{
  return pl.age_ < pr.age_;
}

// 排序时传入比较函数指针
sort(members.begin(), members.end(), CompAge);

// 方式3：仿函数
struct CompName
{
  bool operator()(const Person& pl, const Person& pr)
  {
    return pl.name_ < pr.name_;
  }
};

// 排序时传入函数对象
sort(members.begin(), members.end(), CompName());

用函数对象代替函数指针的优点：
1. 函数对象可以存储中间结果在数据成员中，而函数想要存中间结果须要设全局变量或静态变量，这个是我们不想要的。
2. 在函数对象中编译器可以实现内联调用，从而提升性能。

// 利用函数对象实现升降排序
struct CompNameEx{
  CompNameEx(bool asce) : asce_(asce)
  {}
  bool operator()(const Person& pl, const Person& pr)
  {
    return asce_ ? pl.name_ < pr.name_ : pr.name_ < pl.name_;<span style="white-space:pre">	</span>// 《Eff STL》条款21: 永远让比较函数对相等的值返回false
  }
private:
  bool asce_;
};
// 使用仿函数排序(升降序)
sort(members.begin(), members.end(), CompNameEx(false));
 */