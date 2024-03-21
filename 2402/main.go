package main

func main() {
	//println(최빈값([]int{1, 2, 3, 4, 5, 5, 5, 6, 6, 6, 6, 7}))

	//println(문자열나누기("banana"))
	//println(문자열나누기("abracadabra"))
	//println(문자열나누기("aaevbbbbaxcbw"))

	//n := 5
	//result := 나선형(5)
	//// 생성된 배열 출력
	//for i := 0; i < n; i++ {
	//	for j := 0; j < n; j++ {
	//		fmt.Printf("%d ", result[i][j])
	//	}
	//	fmt.Println()
	//}

	//n := []int{1, 3, 4, 6}

	//println(푸드파이터(n))

	//println(옷가게할인받기(300000))
}

func 최빈값(abc []int) int {
	// Count Map
	count := map[int]int{}
	// 최대 개수
	maxVal := 0
	// 최빈값
	final := -1

	for _, val := range abc {
		count[val]++
		if count[val] > maxVal {
			final = val
			maxVal = count[val]
		} else if count[val] == maxVal {
			final = -1
		}
	}
	return final
}

func 문자열나누기(s string) int {

	div := 0
	for len(s) > 0 {
		x := s[0]
		xCnt := 1
		otherCnt := 0

		for i := 1; i < len(s); i++ {
			if s[i] == x {
				xCnt++
			} else {
				otherCnt++
			}
			if xCnt == otherCnt {
				div++
				s = s[i+1:]
				break
			}
		}
		if xCnt != otherCnt {
			div++
			break
		}

	}
	return div
}

func 나선형(n int) [][]int {
	result := make([][]int, n)
	for i := range result {
		result[i] = make([]int, n)
	}

	// 위치값
	x := 0
	y := 0
	// 방향
	addX := 0
	addY := 1
	// 숫자
	num := 1

	for num <= n*n {
		result[x][y] = num
		num++

		ix := x + addX
		iy := y + addY

		if ix < 0 || ix >= n || iy < 0 || iy >= n || result[ix][iy] != 0 {
			temp := addX
			addX = addY
			addY = -temp
		}

		x = x + addX
		y = y + addY

	}
	return result
}

func 푸드파이터(food []int) string {
	result := ""

	for i, food := range food[1:] {
		var count int = food / 2
		//result += strings.Repeat(strconv.Itoa(i+1), count)
		for j := 0; j < count; j++ {
			//result += strconv.Itoa(i + 1)
			result += string('0' + i + 1)
		}
	}

	reverse := ""
	for i := len(result) - 1; i >= 0; i-- {
		reverse = reverse + string(result[i])
	}

	return result + "0" + reverse
}

func 옷가게할인받기(price int) int {
	discount := 1.0
	if price >= 500000 {
		discount = 0.8
	} else if price >= 300000 {
		discount = 0.9
	} else if price >= 100000 {
		discount = 0.95
	}
	return int(float64(price) * discount)
}

func 피자나눠먹기(n int) int {
	slice := 7
	pizza := n / slice
	if n%slice != 0 {
		pizza += 1
	}
	return pizza
}
